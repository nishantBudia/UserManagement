package com.nishant.UserManagement.Entity;

import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User implements Mergeable<User> {
    public void setUserId(@NonNull Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public Long getUserId() {
        return userId;
    }

    public Address getAddress() {
        return address;
    }

    public String getUserName() {
        return userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    private Long userId;
    private String name;
    private Address address;
    private String userName;
    private String phoneNumber;
    private final HashMap<String,Integer> hits = new HashMap<>();

    public HashMap<String, Integer> getHits() {
        return hits;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public void setAddress(@NonNull Address address) {
        this.address = address;
    }

    public void setUserName(@NonNull String userName) {
        this.userName = userName;
    }

    public void setPhoneNumber(@NonNull String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", address='" + address.toString() + '\'' +
                ", userName='" + userName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    @Override
    public User merge(User replace) {
        this.address.merge(replace.address);
        this.setName(replace.getName()!=null?replace.getName():this.getName());
        this.setUserName(replace.getUserName()!=null? replace.getUserName() : this.getUserName());
        this.setPhoneNumber(replace.getPhoneNumber()!=null? replace.getPhoneNumber() : this.getPhoneNumber());
        return this;
    }
}
