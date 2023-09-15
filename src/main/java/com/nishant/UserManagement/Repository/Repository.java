package com.nishant.UserManagement.Repository;

import com.nishant.UserManagement.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

@org.springframework.stereotype.Repository
public class Repository {

    @Autowired
    HashMap<Long, User> userMap;

    public HashMap<Long, User> getUserMap() {
        return userMap;
    }
}
