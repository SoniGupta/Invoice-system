package com.example.dao;

import com.example.entity.ItemsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface  ItemsDao extends JpaRepository<ItemsEntity, Integer> {




}