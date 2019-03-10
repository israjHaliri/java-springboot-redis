package com.haliri.israj.javaspringbootredis.repository;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by israjhaliri on 9/17/17.
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

    private String key = "student";

    private RedisTemplate<String, String> redisTemplate;

    private HashOperations hashOperations;

    public UserRepositoryImpl(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(String id, String user) {
        hashOperations.putIfAbsent(key, id, user);
    }

    @Override
    public Map<String, Object> findAll() {
        return hashOperations.entries(key);
    }

    @Override
    public String findById(String user) {
        return (String) hashOperations.get(key, user);
    }

    @Override
    public void update(String id, String user) {
        hashOperations.put(key, id, user);
    }

    @Override
    public void delete(String id) {
        hashOperations.delete(key, id);
    }
}
