package cn.lantian.ssm.redis.listener;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Created by Lzbin、LANTIAN on 2017/10/23.
 *
 * @version 1.0
 * @PACKAGE_NAME cn.lantian.ssm.redis.listener
 * @Dercripton
 * @Time 9:40
 */
public class RedisMessageListener implements MessageListener {
    public RedisTemplate redisTemplate;

    public RedisTemplate getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        //获取消息
        byte[] body = message.getBody();
        //使用之序列化器转换
        String msgBody = (String) getRedisTemplate().getValueSerializer().deserialize(body);
        System.err.println(msgBody);
        //获取channel频道
        byte[] channel = message.getChannel();
        //使用字符串序列化器转换
        String channelStr = (String) getRedisTemplate().getValueSerializer().deserialize(channel);
        System.err.println(channelStr);
        //渠道名称转换
        String bytesStr = new String(pattern);
        System.err.println(bytesStr);
    }
}
