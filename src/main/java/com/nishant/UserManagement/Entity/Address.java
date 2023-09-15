package com.nishant.UserManagement.Entity;

import org.springframework.lang.NonNull;

public class Address implements Mergeable<Address> {
    public Address(String flatNumber, String street, String area, Integer zipcode, String country, String state) {
        this.flatNumber = flatNumber;
        this.street = street;
        this.area = area;
        this.zipcode = zipcode;
        this.country = country;
        this.state = state;
    }

    public String getFlatNumber() {
        return flatNumber;
    }

    public String getStreet() {
        return street;
    }

    public String getArea() {
        return area;
    }

    public Integer getZipcode() {
        return zipcode;
    }

    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }

    public void setFlatNumber(@NonNull String flatNumber) {
        this.flatNumber = flatNumber;
    }

    public void setStreet(@NonNull String street) {
        this.street = street;
    }

    public void setArea(@NonNull String area) {
        this.area = area;
    }

    public void setZipcode(@NonNull Integer zipcode) {
        this.zipcode = zipcode;
    }

    public void setCountry(@NonNull String country) {
        this.country = country;
    }

    public void setState(@NonNull String state) {
        this.state = state;
    }

    private String flatNumber;
    private String street;
    private String area;
    private Integer zipcode;
    private String country;
    private String state;

    @Override
    public String toString() {
        return "Address{" +
                "flatNumber='" + flatNumber + '\'' +
                ", street='" + street + '\'' +
                ", area='" + area + '\'' +
                ", zipcode=" + zipcode +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    @Override
    public Address merge(Address replace) {
        this.setArea(replace.getArea()!=null?replace.getArea():this.getArea());
        this.setCountry(replace.getCountry()!=null?replace.getCountry():this.getCountry());
        this.setState(replace.getState()!=null?replace.getState():this.getState());
        this.setStreet(replace.getStreet()!=null?replace.getStreet():this.getStreet());
        this.setZipcode(replace.getZipcode()!=null? replace.getZipcode() : this.getZipcode());
        this.setFlatNumber(replace.getFlatNumber()!=null?replace.getFlatNumber():this.getFlatNumber());
        return this;
    }
}
