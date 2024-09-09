package com.example.dao;

import java.util.List;

import com.example.entity.UserEntity;

public interface UserDao {
    UserEntity save(UserEntity user);
    List<UserEntity> findAll();
}
