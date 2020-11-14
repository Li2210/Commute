package com.elec5620.commute.Dao;

import com.elec5620.commute.pojo.User;

import java.util.List;

/**
 * @Description TODO
 * @Author lishen
 * @Date 5/11/20 21:17
 **/
public interface UserDao {

    // query all users
    List<User> getAllUserInfo();

    // get user by id
    User getSpecificUser(Integer id);

    // update user info
    int updateUserInfo(User user);

    // add user
    int addUser(User user);

    //delete user by id
    int deleteUser(Integer id);

    // get user by username and password
    User loginUser(String username, String password);

    // get user by username
    User getUserByUsername(String username);

}
