package cn.lantian.ssm.RedisTest.事物;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Lzbin、LANTIAN on 2017/10/12.
 *
 * @version 1.0
 * @PACKAGE_NAME cn.lantian.ssm.RedisTest
 * @Dercripton
 * @Time 14:46
 */

@RunWith(SpringJUnit4ClassRunner.class)//表示整合JUnit4进行测试
@ContextConfiguration(locations = {"classpath:spring/applicationContext-dao.xml"})//加载spring配置文件
public class demoTest {

    //自动注入Spring的Redis操作
    @Autowired
    private RedisTemplate redisTemplate;

    //事物应用1
    @Test
    public void fun1() {
        SessionCallback callback = new SessionCallback() {
            @Override
            public Object execute(RedisOperations ops) throws DataAccessException {
                //命令进入事物队列
                ops.multi();
                //增加key1
                ops.boundValueOps("key1").set("value1");
                //注意命令只是进入队列、而没有被执行、所以此处采用get命令、而value却返回为null
                String value = (String) ops.boundValueOps("key1").get();
                System.out.println("执行事物中、命令进入队列、而没有被执行、所以value为空" +
                        "value=" + value);
                //此时List会保存之前进入队列的所有命令的结果
                List list = ops.exec();
                //事务结束后
                value = (String) redisTemplate.opsForValue().get("key1");
                return value;
            }
        };

        String value = (String) redisTemplate.execute(callback);
        System.out.println(value);
    }
}


