package com.example.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "customer")
public class CustomerEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "phone")
    private String phone;

    @NotNull
    private String name;

    @NotNull
    private String address;

    @NotNull
    private String email;




    public CustomerEntity(){}

    public CustomerEntity(String phone,String name,String address,String email){
        this.phone=phone;
        this.name=name;
        this.address=address;
        this.email=email;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}




