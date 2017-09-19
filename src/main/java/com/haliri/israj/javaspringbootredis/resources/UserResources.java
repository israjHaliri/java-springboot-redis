package com.haliri.israj.javaspringbootredis.resources;

import com.haliri.israj.javaspringbootredis.domain.User;
import com.haliri.israj.javaspringbootredis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by israjhaliri on 9/17/17.
 */
@RestController
@RequestMapping("/rest/user")
public class UserResources {

    @Autowired
    private UserRepository userRepository;

    public UserResources(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/add/{id}/{name}")
    public User add(@PathVariable("id") final String id, @PathVariable("name") final String name){
        userRepository.save(new User(id,name,20000L));
        return userRepository.findById(id);
    }

    @GetMapping("/update/{id}/{name}")
    public User update(@PathVariable("id") final String id, @PathVariable("name") final String name){
        userRepository.save(new User(id,name,1000L));
        return userRepository.findById(id);
    }

    @GetMapping("/delete/{id}")
    public User update(@PathVariable("id") final String id){
        userRepository.delete(id);
        return userRepository.findById(id);
    }

    @GetMapping("/all")
    public Map<String,User> update(){
        return  userRepository.findAll();
    }
}
