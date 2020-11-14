package com.elec5620.commute.Service.Impl;

import com.elec5620.commute.Dao.UserDao;
import com.elec5620.commute.Service.UserService;
import com.elec5620.commute.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description TODO
 * @Author lishen
 * @Date 6/11/20 15:10
 **/
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public List<User> getAllUserInfo() {
        List<User> allUser = this.userDao.getAllUserInfo();
        return allUser;
    }

    @Override
    public User loginUser(String username, String password) {
        User user = userDao.loginUser(username, password);
        return user;

    }

    @Override
    public int addUser(String username, String password, String address, String phoneNumber) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setAddress(address);
        user.setPhoneNumber(phoneNumber);
        return this.userDao.addUser(user);
    }

    @Override
    public boolean userRegistered(String username) {
        User user = userDao.getUserByUsername(username);
        if (user != null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public User getUserByUsername(String username) {
        User user = userDao.getUserByUsername(username);
        return user;
    }

    @Override
    public User getUserById(int id) {
        User user = userDao.getSpecificUser(id);
        return user;
    }
}
