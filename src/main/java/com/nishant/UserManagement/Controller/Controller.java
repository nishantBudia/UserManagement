package com.nishant.UserManagement.Controller;

import com.nishant.UserManagement.Entity.User;
import com.nishant.UserManagement.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class Controller {

    @Autowired
    Service service;

    //CREATE API
    @PostMapping("addUser")
    public String addUser(@RequestBody User user){
        return service.addUser(user);
    }

    //READ API
    @GetMapping("getAllUser")
    public HashMap<Long,User> getAllUser(){
        return service.getAllUser();
    }

    @GetMapping("getUser/{userId}")
    public User getUser(@PathVariable Long userId){
        return service.getUser(userId);
    }

    //UPDATE API

    @PutMapping("UpdateUserInfo")
    public String updateUserInfo(@RequestBody User user){
        return service.updateUserInfo(user);
    }

    //DELETE API

    @DeleteMapping("DeleteUser")
    public String deleteUser(@RequestParam Long id){
        return service.deleteUser(id);
    }

}
