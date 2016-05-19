package com.example.controller;

import com.example.dao.*;
import com.example.entity.UserEntity;
import com.example.entity.UserRoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.List;

@Controller
public class TestController {


    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @ResponseBody
    public UserEntity currentUser(Principal principal) {
        String user = principal.getName();
       UserEntity userEntity = userDao.findByUsername(user);
        return userEntity;
    }




    @RequestMapping("/adduser")
    @ResponseBody
    public UserEntity create(String username, String password,String name, String fatherName,
                                 String address, String email, String phone, String gender, String enabled,String role)
    {
       //to find whether user exists or nt
        UserEntity user = userDao.findByUsername(username);
        UserRoleEntity userRoleEntity;
        if(user == null) {
            user = new UserEntity(username, password, name, fatherName, address, email, phone, gender, enabled);
            userRoleEntity=new UserRoleEntity();
        } else {
            user.setPassword(password);
            user.setName(name);
            user.setFatherName(fatherName);
            user.setAddress(address);
            user.setEmail(email);
            user.setPhone(phone);
            user.setGender(gender);
            user.setEnabled(enabled);

            userRoleEntity = user.getUserRoleEntity();
        }

        user = userDao.save(user);
        userRoleEntity.setRole(role);
        userRoleEntity.setUserEntity(user);

        userRoleDao.save(userRoleEntity);

        user.setUserRoleEntity(userRoleEntity);
        return user;
    }


    @RequestMapping(value = "/addusernew" , method = RequestMethod.POST)
    @ResponseBody
    public UserEntity createnew( @RequestBody UserEntity userEntity)
    {
        UserRoleEntity userRoleEntity = userEntity.getUserRoleEntity();
        userRoleEntity.setUserEntity(userEntity);
        return userDao.save(userEntity);
    }



//    @RequestMapping(value = "/editinvoice" , method = RequestMethod.POST)
//    @ResponseBody
//    public InvoiceEntity edit( @RequestBody InvoiceEntity invoiceEntity)
//    {
//      return invoiceEntity;
//
//    }


    @RequestMapping(value = "/allusers", produces = {"application/json"})
    @ResponseBody
    public List<UserEntity> showall() {
        List<UserEntity> userList;
      userList = userDao.findAll();
        return userList;
    }



    @RequestMapping(value = "/delete")
    @ResponseBody
    public String delete(Integer userid) {
        UserEntity user = new UserEntity(userid);
        userDao.delete(user);
        return "User succesfully deleted!";
    }

//    @RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE)
//    public ResponseEntity<String> deleteEmployee(@PathVariable("id") int id)
//    {
//        EmployeeVO employee = _getEmployeeById(id);
//        if(employee != null){
//            employees.getEmployees().remove(employee);
//            return new ResponseEntity<String>(HttpStatus.OK);
//        }
//        return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
//    }



@Autowired
    private CustomerDao customerDao;
    @Autowired
    private InvoiceDao invoiceDao;
    @Autowired
    private ItemsDao itemsDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserRoleDao userRoleDao;

}