package com.nishant.UserManagement.Repository;

import com.nishant.UserManagement.Entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
public class DataSource {

    @Bean
    public HashMap<Long, User> createMap(){
        return new HashMap<>();
    }

}
