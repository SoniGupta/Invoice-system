package com.example.controller;

import com.example.dao.CustomerDao;
import com.example.entity.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    private CustomerDao customerDao;


    @RequestMapping("/searchcustomer")
    public  CustomerEntity find(String phone){
        CustomerEntity customerEntity= customerDao.findByPhone(phone);
        return customerEntity;
    }


}
