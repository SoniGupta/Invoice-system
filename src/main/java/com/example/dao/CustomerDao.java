package com.example.dao;

import com.example.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CustomerDao extends JpaRepository<CustomerEntity, String> {
//to search we can use both methods
//    @Query("select c from CustomerEntity c where c.phone=?1")
//    public CustomerEntity search(String phone);

    CustomerEntity findByPhone(String phone);


}
