package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/welcome").setViewName("welcome");
//        registry.addViewController("/").setViewName("welcome");
        //registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/signin").setViewName("signin");
    }

}


