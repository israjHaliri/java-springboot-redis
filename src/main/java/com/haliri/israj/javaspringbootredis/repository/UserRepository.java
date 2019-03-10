package com.haliri.israj.javaspringbootredis.repository;

import java.util.Map;

/**
 * Created by israjhaliri on 9/17/17.
 */
public interface UserRepository {

    void save(String id, String user);

    Map<String, Object> findAll();

    String findById(String id);

    void update(String id, String user);

    void delete(String id);
}
