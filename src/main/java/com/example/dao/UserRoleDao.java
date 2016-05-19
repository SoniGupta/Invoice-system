package com.example.dao;

import com.example.entity.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface UserRoleDao extends JpaRepository<UserRoleEntity, Integer> {
    @Modifying
    @Query("select a.role from UserRoleEntity a, UserEntity b where b.username=?1 and a.userEntity.userid=b.userid")
    public List<String> findRoleByUsername(String username);



}

