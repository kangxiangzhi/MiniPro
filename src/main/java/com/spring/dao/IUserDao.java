package com.spring.dao;

import java.util.List;

import com.spring.entity.User;

public interface IUserDao {

    boolean add(User user);

    boolean add(List<User> list);

    void delete(String key);
    
    void delete(List<String> keys);

  
    boolean update(User user);


    User get(String keyId);
}