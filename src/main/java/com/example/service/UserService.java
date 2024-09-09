package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UserDao;
import com.example.entity.UserEntity;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public UserEntity save(UserEntity user) {
        return userDao.save(user);
    }

    public List<UserEntity> getAllUsers() {
        return userDao.findAll();
    }
}
