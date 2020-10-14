package com.example.springboot.service.impl;

import com.example.springboot.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author Liangyifeng
 * @created 2020/10/12/09:49
 */
@Service
public class RedisServiceImpl implements RedisService {


    @Autowired
    private RedisTemplate<String, String> redisTemplate;	//Spring自动注入RedisTemplate


    @Override
    public void addKey(String key, String value) {
        // 20: 表示该数据在缓存中存在的时间，TimeUnit.SECONDS为单位秒，
        // 20秒后缓存中的数据会自动消失
        redisTemplate.opsForValue().set(key,value,3*60, TimeUnit.SECONDS);
    }

    @Override
    public String getValueByKey(String key) {
        return (String) redisTemplate.opsForValue().get(key);
    }
}
