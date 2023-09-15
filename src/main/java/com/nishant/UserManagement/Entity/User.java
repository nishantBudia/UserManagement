package com.nishant.UserManagement.Entity;

public class User implements Mergeable<User> {
    public void setUserId(Long userId) {
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

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = this.address.merge(address);
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPhoneNumber(String phoneNumber) {
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
        this.setAddress(replace.getAddress()!=null?replace.getAddress():this.getAddress());
        this.setName(replace.getName()!=null?replace.getName():this.getName());
        this.setUserName(replace.getUserName()!=null? replace.getUserName() : this.getUserName());
        this.setPhoneNumber(replace.getPhoneNumber()!=null? replace.getPhoneNumber() : this.getPhoneNumber());
        return this;
    }
}
