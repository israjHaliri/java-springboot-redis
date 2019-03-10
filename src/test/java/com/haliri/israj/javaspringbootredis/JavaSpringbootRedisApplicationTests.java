package com.haliri.israj.javaspringbootredis;

import com.haliri.israj.javaspringbootredis.domain.User;
import com.haliri.israj.javaspringbootredis.repository.CatchRepository;
import com.haliri.israj.javaspringbootredis.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JavaSpringbootRedisApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CatchRepository catchRepository;

    @Test
    public void contextLoads() {
        userRepository.save("1", "israj");

        Map<String, Object> val = userRepository.findAll();
        val.forEach((s, o) -> {
            System.out.println("value : " + s + ", " + o);
        });

        userRepository.update("1", "israj haliri");

        System.out.println("value : " + "1" + ", " + userRepository.findById("1"));

        userRepository.delete("1");


        System.out.println("-------------------------------");
        catchRepository.findAll().forEach(s -> {
            System.out.println("value " + s.getId() + " : " + s.getName());
        });

        catchRepository.update(new User("1", "jono haliri"));
        System.out.println("value " + catchRepository.findById("1").getId() + " : " + catchRepository.findById("1").getName());

        catchRepository.delete("id");
    }

}
