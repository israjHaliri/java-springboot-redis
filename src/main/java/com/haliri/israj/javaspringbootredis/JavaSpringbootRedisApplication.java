package com.haliri.israj.javaspringbootredis;

import com.haliri.israj.javaspringbootredis.domain.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
public class JavaSpringbootRedisApplication {

	@Bean
	JedisConnectionFactory jedisConnectionFactory(){
		return  new JedisConnectionFactory();
	}

	@Bean
	RedisTemplate<String, User> redisTemplate(){
		RedisTemplate<String, User> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return redisTemplate;
	}

	public static void main(String[] args) {
		SpringApplication.run(JavaSpringbootRedisApplication.class, args);
	}
}
