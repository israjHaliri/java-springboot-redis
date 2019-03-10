package com.haliri.israj.javaspringbootredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
@EnableCaching
public class JavaSpringbootRedisApplication {

	@Bean
	RedisTemplate<Object, Object> redisTemplate(){
		RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());

		return redisTemplate;
	}

	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		JedisConnectionFactory jedisConFactory
				= new JedisConnectionFactory();
		jedisConFactory.setHostName("127.0.0.1");
		jedisConFactory.setPort(6379);
		return jedisConFactory;
	}

	public static void main(String[] args) {
		SpringApplication.run(JavaSpringbootRedisApplication.class, args);
	}
}
