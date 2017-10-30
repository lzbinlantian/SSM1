package cn.lantian.ssm.RedisTest.流水线;

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
 * Created by Lzbin、LANTIAN on 2017/10/23.
 *
 * @version 1.0
 * @PACKAGE_NAME cn.lantian.ssm.RedisTest.流水线
 * @Dercripton
 * @Time 8:58
 */

@RunWith(SpringJUnit4ClassRunner.class)//表示整合JUnit4进行测试
@ContextConfiguration(locations = {"classpath:spring/applicationContext-dao.xml"})//加载spring配置文件
public class demo1 {
    //自动注入Spring的Redis操作
    @Autowired
    private RedisTemplate redisTemplate;


    //使用Spring操作Redis流水线
    @Test
    public void testPipeline() {
        //使用JDK8的Lambda表达式
        SessionCallback callback = new SessionCallback() {
            @Override
            public Object execute(RedisOperations redisOperations) throws DataAccessException {
                for (int i = 0; i < 100000; i++) {
                    int j = i + 1;
                    redisOperations.boundValueOps("pipeline_key_" + j).set("pipeline_value_" + j);
                    redisOperations.boundValueOps("pipeline_key_" + j).get();
                }
                return null;
            }
        };
        long start = System.currentTimeMillis();
        //执行Redis的流水线命令
        List resultList = redisTemplate.executePipelined(callback);
        System.out.println(resultList);
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

}
