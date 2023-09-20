package com.nishant.UserManagement.Controller;

import com.nishant.UserManagement.Entity.User;
import com.nishant.UserManagement.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    //CREATE API
    @PostMapping("addUser")
    public String addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    //READ API
    @GetMapping("getAllUser")
    public HashMap<Long,User> getAllUser(){
        return userService.getAllUser();
    }

    @GetMapping("getUser/{userId}")
    public User getUser(@PathVariable Long userId){
        return userService.getUser(userId);
    }

    //UPDATE API

    @PutMapping("UpdateUserInfo")
    public String updateUserInfo(@RequestBody User user){
        return userService.updateUserInfo(user);
    }

    //DELETE API

    @DeleteMapping("DeleteUser")
    public String deleteUser(@RequestParam Long id){
        return userService.deleteUser(id);
    }

}
