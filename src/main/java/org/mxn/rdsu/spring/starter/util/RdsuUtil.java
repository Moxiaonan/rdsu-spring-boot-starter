package org.mxn.rdsu.spring.starter.util;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.util.List;
import java.util.Set;

public class RdsuUtil {
    private RedisTemplate redisTemplate;

    public RdsuUtil(RedisTemplate redisTemplate) {
        RedisSerializer<String> keySerializer = RedisSerializer.string();
//        与 Jackson2JsonRedisSerializer 相比 GenericJackson2JsonRedisSerializer 生成的json中带有@class属性 方便进行泛型转换
        GenericJackson2JsonRedisSerializer valueSerializer = new GenericJackson2JsonRedisSerializer();
        redisTemplate.setKeySerializer(keySerializer);
        redisTemplate.setValueSerializer(valueSerializer);
        redisTemplate.setHashKeySerializer(keySerializer);
        redisTemplate.setHashValueSerializer(valueSerializer);
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

//    type : hash
    public <T> void hSet(String key,String hashKey,T value){
        redisTemplate.opsForHash().put(key,hashKey,value);
    }

    public <T> T hGet(String key,String hashKey,Class<T> clazz){
        return (T) redisTemplate.opsForHash().get(key,hashKey);
    }

//    type : set
    public <T> void sAdd(String key,T... value){
        redisTemplate.opsForSet().add(key,value);
    }

    public <T> Set<T> sMembers(String key,Class<T> clazz){
        return (Set<T>)redisTemplate.opsForSet().members(key);
    }
}
