package com.haliri.israj.javaspringbootredis.domain;

import java.io.Serializable;

/**
 * Created by israjhaliri on 9/16/17.
 */
public class User implements Serializable{
    String id;
    String name;
    Long salary;

    public User(String id, String name, Long salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }
}
