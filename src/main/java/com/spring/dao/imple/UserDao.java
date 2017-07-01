package com.spring.dao.imple;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.spring.entity.User;
@Repository
public class UserDao {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	private static String PERSON_KEY = "Person";


	public void save(User user) {
		this.redisTemplate.opsForHash().put(PERSON_KEY, user.getId(), user);
	}

	public User find(String id) {
		return (User) this.redisTemplate.opsForHash().get(PERSON_KEY, id);
	}

	public Map<Object, Object> findAll() {
		return this.redisTemplate.opsForHash().entries(PERSON_KEY);
	}

	public void delete(String id) {
		this.redisTemplate.opsForHash().delete(PERSON_KEY, id);

	}

}