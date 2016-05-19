package com.example.dao;

import com.example.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserDao extends JpaRepository<UserEntity, Integer> {

    public UserEntity findByUsername(String username);


}

