package com.example.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "user")
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Integer userid;

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "father_name")
    private String fatherName;

    @NotNull
    private String address;

    @NotNull
    private String email;

    @NotNull
    @Column(name = "phone")
    private String phone;

    @NotNull
    private String gender;

    @NotNull
    private String enabled;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "userEntity", cascade = CascadeType.ALL)
    private UserRoleEntity userRoleEntity;


    public UserEntity() {
    }

    public UserEntity(UserEntity userEntity) {
        this(userEntity.getUsername(),userEntity.getPassword(),userEntity.getName(),userEntity.getFatherName(),
                userEntity.getAddress(),userEntity.getEmail(),userEntity.getPhone(),userEntity.getGender(),
                userEntity.getEnabled());


    }

    public UserEntity(String username, String password, String name, String fatherName,
                      String address, String email, String phone, String gender, String enabled) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.fatherName = fatherName;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.enabled = enabled;
    }


    public UserEntity(Integer userid) {
        this.userid=userid;

    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public UserRoleEntity getUserRoleEntity() {
        return userRoleEntity;
    }

    public void setUserRoleEntity(UserRoleEntity userRoleEntity) {
        this.userRoleEntity = userRoleEntity;
    }


}