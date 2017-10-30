package cn.lantian.ssm.RedisTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

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

    //基础入门
    @Test
    public void fun1() {
        //新建一个实现了序列号接口Serializable的类
        final Role role = new Role();
        //添加基本数据
        role.setId(1L);
        role.setRoleName("Name_LANTIAN");
        role.setNote("Note_大神");
        //可以直接写在外面。但是这样无法保证是用了同一个连接
        /*redisTemplate.opsForValue().set("role_1", role);
        Role role1 = (Role) redisTemplate.opsForValue().get("role_1");*/

        //因为无法保证用的是同一个连接、以及同一个Redis、所以要实现SessionCallback接口
        //通过重写方法来执行
        SessionCallback<Role> callback = new SessionCallback<Role>() {
            @Override
            public Role execute(RedisOperations redisOperations) throws DataAccessException {
                //                                 key      value
                redisOperations.opsForValue().set("role_1", role);
                //                                               key
                return (Role) redisOperations.opsForValue().get("role_1");
            }
        };

        Role role1 = (Role) redisTemplate.execute(callback);

        System.out.println(role1);
    }


    //Redis数据结构---哈希 最常用！~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    @Test
    public void testRedisHash() {
        //存储的hashmap表
        String key = "hash";
        Map<String, String> map = new HashMap<String, String>();
        map.put("f1", "蓝天1");
        map.put("f2", "蓝天2");
        //相当于hmset命令 将map集合装进去
        redisTemplate.opsForHash().putAll(key, map);
        //相当于hset命令 设置自己装进去的map集合
        redisTemplate.opsForHash().put(key, "f3", "蓝天3");
        printValueForHash(redisTemplate, key, "f3");
        //相当于hexists key field 就是说判断是不是存在的、如果不存在才添加
        boolean exsts = redisTemplate.opsForHash().hasKey(key, "f4");
        //redisTemplate.opsForHash().put(key, "f4", 1);
        //相当于hgetall 获得Map
        Map keyValMap = redisTemplate.opsForHash().entries(key);
        //相当于hincrby 整数增加
        redisTemplate.opsForHash().increment(key, "f4", 2);
        printValueForHash(redisTemplate, key, "f4");
        //相当于hvals 获得list集合、存储的值
        List<String> valueList = redisTemplate.opsForHash().values(key);
        //想到于hkeys  得到全部的key
        Set keyList = redisTemplate.opsForHash().keys(key);
        List<String> fieldList = new ArrayList<String>();
        fieldList.add("f1");
        fieldList.add("f2");
        //相当于hmget  通过键值寻找值
        List valueList2 = redisTemplate.opsForHash().multiGet(key, keyList);
        //相当于hsetnx 如果不存在f4 、就增加一对
        boolean success = redisTemplate.opsForHash().putIfAbsent(key, "f4", "val4");
        //相当于hdel命令 找到hashMap 通过键来删除值
        Long result = redisTemplate.opsForHash().delete(key, "f1", "f2");
        System.out.println(result);
    }




    public static void printValueForHash(RedisTemplate redisTemplate, String key, String field) {
        Object value = redisTemplate.opsForHash().get(key, field);
        System.out.println(value);
    }




}
