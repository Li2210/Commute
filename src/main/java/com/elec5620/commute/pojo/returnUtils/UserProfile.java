package com.elec5620.commute.pojo.returnUtils;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description TODO
 * @Author lishen
 * @Date 13/11/20 03:48
 **/
@Data
public class UserProfile implements Serializable {

    private int id;
    private String username;
    private String address;
    private String phoneNumber;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
