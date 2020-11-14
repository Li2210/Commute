package com.elec5620.commute.Service;

import com.elec5620.commute.pojo.User;

import java.util.List;

/**
 * @Description TODO
 * @Author lishen
 * @Date 5/11/20 21:38
 **/
public interface UserService {

    List<User> getAllUserInfo();

    User loginUser(String username, String password);

    int addUser(String username, String password, String address, String phoneNumber);

    boolean userRegistered(String username);

    User getUserByUsername(String username);

    User getUserById(int id);
}
