package com.haliri.israj.javaspringbootredis.repository;

import com.haliri.israj.javaspringbootredis.domain.User;

import java.util.List;

/**
 * Created by israjhaliri on 9/17/17.
 */
public interface CatchRepository {

    User save(User user);

    public List<User> findAll();

    User findById(String id);

    User update(User user);

    void delete(String id);
}
