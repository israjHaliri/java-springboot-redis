package com.haliri.israj.javaspringbootredis.repository;

import com.haliri.israj.javaspringbootredis.domain.User;

import java.util.List;
import java.util.Map;

/**
 * Created by israjhaliri on 9/17/17.
 */
public interface UserRepository {

    void save(User user);
    Map<String,User> findAll();
    User findById(String id);
    void update(User user);
    void delete(String id);
}
