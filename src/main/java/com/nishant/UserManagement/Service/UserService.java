package com.nishant.UserManagement.Service;

import com.nishant.UserManagement.Entity.User;
import com.nishant.UserManagement.Repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

@org.springframework.stereotype.Service
public class UserService {

    @Autowired
    Repository repository;


    public String addUser( User user){
        Long id = (long)(Math.random()*Long.MAX_VALUE);
        while(repository.getUserMap().containsKey(id)){
            id = (long)(Math.random()*Long.MAX_VALUE);
        }
        user.setUserId(id);
        repository.getUserMap().put(id,user);
        return "User "+user.getUserId()+" added";
    }

    public HashMap<Long, User> getAllUser() {
        return repository.getUserMap();
    }

    public User getUser(Long userId) {
        return repository.getUserMap().get(userId);
    }

    public String updateUserInfo(User user){
        if(user==null||!repository.getUserMap().containsKey(user.getUserId())){
            return "User not found";
        }
        repository.getUserMap().get(user.getUserId()).merge(user);
        return "Updated user info for user "+user.getUserId();
    }

    public String deleteUser(Long id) {
        if(repository.getUserMap().containsKey(id)){
            repository.getUserMap().remove(id);
            return "User "+id+" removed";
        }
        return "Id not found";
    }
}
