package org.mxn.rdsu.spring.starter.util;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.util.List;

public class RdsuUtil {
    private RedisTemplate redisTemplate;

    public RdsuUtil(RedisTemplate redisTemplate) {
        redisTemplate.setKeySerializer(RedisSerializer.string());
//        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Object.class));
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setHashValueSerializer(RedisSerializer.string());
//        redisTemplate.setHashValueSerializer(new Jackson2JsonRedisSerializer<>(Object.class));
        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
        this.redisTemplate = redisTemplate;
    }

    public Object get(String key){
        return redisTemplate.opsForValue().get(key);
    }

//    type : String
    public <T> T get(String key,Class<T> clazz){
        Object o = get(key);
        return (T) o;
    }

    public <T> void set(String key,T t){
        redisTemplate.opsForValue().set(key,t);
    }


//    type : List
    public Object lIndex(String key,Integer idx){
        return redisTemplate.opsForList().index(key,idx);
    }

    public <T> T lIndex(String key,Integer idx,Class<T> clazz){
        return (T) lIndex(key,idx);
    }

    public List lRange(String key,Integer begin,Integer end){
        return redisTemplate.opsForList().range(key,begin,end);
    }

    public <T> List<T> lRange(String key,Integer begin,Integer end,Class<T> clazz){
        return (List<T>) lRange(key,begin,end);
    }

    public <T> void lPush(String key,T value){
        redisTemplate.opsForList().leftPush(key,value);
    }
}
