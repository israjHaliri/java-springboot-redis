package com.haliri.israj.javaspringbootredis.repository;

import com.haliri.israj.javaspringbootredis.domain.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by israjhaliri on 9/17/17.
 */
@Repository
public class CatchRepositoryImpl implements CatchRepository {

    private final String key = "teacher";

    @Override
    public User save(User user) {
        return user;
    }

    @Override
    @Cacheable(value = key)
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();
        userList.add(new User("1", "jono"));

        return userList;
    }

    @Override
    @Cacheable(value = key, key = "#id")
    public User findById(String id) {
        return null;
    }

    @Override
    @CachePut(value = key, key = "#user.id")
    public User update(User user) {
        return user;
    }

    @Override
    @CacheEvict(value = key, key = "#id")
    public void delete(String id) {
    }
}
