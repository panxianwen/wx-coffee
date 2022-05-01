package com.yu.common.service;

import com.yu.common.constant.Const;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;

// 锁服务
@Slf4j
@Service
public class LockService {

    @Resource
    private RedisTemplate redisTemplate;
    @Autowired
    private JedisPool jedisPool;


    // TODO redis分布式锁
    // **************** 乐观锁 ***************** //
    public boolean tryLock(String key, String value, long time) {
        try {
            return redisTemplate.opsForValue()
                    .setIfAbsent(Const.CONST_user_take_order_lock_prefix + key, value, Duration.ofSeconds(time));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
    }


    public boolean releaseLock(String key) {
        return redisTemplate.delete(key);
    }

    // TODO  使用Lua脚本或redis事务确保2条命令的原子性
    public boolean releaseLock(String key, String value) {
        try (Jedis jedis = jedisPool.getResource()) {
            String luaScript = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
            Object o = jedis.eval(luaScript, Collections.singletonList(key), Collections.singletonList(value));
            return "1".equals(o.toString());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return false;
    }

}
