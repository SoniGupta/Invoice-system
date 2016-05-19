package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;


    @Configuration
    @EnableWebMvcSecurity
    @ComponentScan(basePackageClasses = CustomUserDetailsService.class)
    public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
        @Autowired
        private UserDetailsService userDetailsService;

        @Autowired
        public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userDetailsService);//.passwordEncoder(passwordencoder());
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                    .antMatchers("/css/**").permitAll()
                    .antMatchers("/js/**").permitAll()
                    .antMatchers("/fonts/**").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .formLogin().defaultSuccessUrl("/index.html", true)
                    .loginPage("/signin").permitAll()
                    .usernameParameter("username").passwordParameter("password")
                    .and()
                    .logout().permitAll()
                    .and()
                    .csrf().disable();
        }

    }
