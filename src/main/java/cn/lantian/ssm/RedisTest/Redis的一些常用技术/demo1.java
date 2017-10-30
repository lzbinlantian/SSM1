package cn.lantian.ssm.RedisTest.Redis的一些常用技术;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Lzbin、LANTIAN on 2017/10/23.
 *
 * @version 1.0
 * @PACKAGE_NAME cn.lantian.ssm.RedisTest.Redis的一些常用技术
 * @Dercripton
 * @Time 9:32
 */
@RunWith(SpringJUnit4ClassRunner.class)//表示整合JUnit4进行测试
@ContextConfiguration(locations = {"classpath:spring/applicationContext-dao.xml"})//加载spring配置文件
public class demo1 {

    //自动注入Spring的Redis操作
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void chat() {
        String channel = "chat";
        redisTemplate.convertAndSend(channel, "I am god!!!");

    }



}
