package com.cgutech.roadcloud.dao;

import com.cgutech.roadcloud.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Becan on 2017/6/8.
 */
@Service
public class RedisDaoImpl implements RedisDao{
    @Autowired
    @Qualifier("template")
    RedisTemplate template;

    @Override
    public boolean set(final String key, final String value) {
        boolean result=(Boolean) template.execute(new RedisCallback() {
            @Override
            public Boolean doInRedis(RedisConnection redisConnection) throws DataAccessException {
                RedisSerializer<String> serializer = template.getStringSerializer();
                redisConnection.set(serializer.serialize(key),serializer.serialize(value));
                return true;
            }
        });
        return result;
    }

    @Override
    public String get(final String key) {
        String result = (String) template.execute(new RedisCallback() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                byte[] value=redisConnection.get(template.getStringSerializer().serialize(key));
                return template.getStringSerializer().deserialize(value);
            }
        });
        return result;
    }

    @Override
    public boolean expire(String key, long expire) {
        return template.expire(key,expire, TimeUnit.SECONDS);
    }

    @Override
    public <T> boolean setList(String key, List<T> list) {
        return set(key, JsonUtil.toJson(list));
    }

    @Override
    public <T> List<T> getList(String key, Class<T> clz) {
        String json = get(key);
        if(json!= null){
            return JsonUtil.toList(json,clz);
        }
        return null;
    }

    @Override
    public long lpush(final String key, Object obj) {
        final String value = JsonUtil.toJson(obj);
        long result = (Long) template.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = template.getStringSerializer();
                long count = connection.lPush(serializer.serialize(key), serializer.serialize(value));
                return count;
            }
        });
        return result;
    }

    @Override
    public long rpush(final String key, Object obj) {
        final String value = JsonUtil.toJson(obj);
        long result = (Long) template.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = template.getStringSerializer();
                long count = connection.rPush(serializer.serialize(key), serializer.serialize(value));
                return count;
            }
        });
        return result;
    }

    @Override
    public String lpop(final String key) {
        String result = (String) template.execute(new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = template.getStringSerializer();
                byte[] res =  connection.lPop(serializer.serialize(key));
                return serializer.deserialize(res);
            }
        });
        return result;
    }
}
