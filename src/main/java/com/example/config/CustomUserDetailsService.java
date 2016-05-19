package com.example.config;

import com.example.dao.UserDao;
import com.example.dao.UserRoleDao;
import com.example.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by soni on 28/4/16.
 */
@Service("customUserDetailsService")
 public class CustomUserDetailsService implements UserDetailsService{
  private final UserDao userDao;
   private final UserRoleDao userRoleDao;

    @Autowired
    public CustomUserDetailsService(UserDao userDao, UserRoleDao userRoleDao) {
        this.userDao = userDao;
        this.userRoleDao = userRoleDao;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       UserEntity userEntity = userDao.findByUsername(username);
        if (null == userEntity) {
            throw new UsernameNotFoundException("No user present with username: " + username);
        }
        else {
            List<String> userRoles = userRoleDao.findRoleByUsername(username);
            return new CustomUserDetails(userEntity,userRoles);     }
    }

}
