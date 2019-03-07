package com.leixiao.socketDemo.service;

import com.leixiao.socketDemo.dao.UserDao;
import com.leixiao.socketDemo.entiy.User;

public class UserService {

    private UserDao userDao = new UserDao();

    public int regist(User user){
        return userDao.register(user);
    }

    public boolean vetifyUser(User user){
        String password = userDao.validate(user.getUsername());
        if(user.getPassword().equals(password)){
            return true;
        }else {
            return false;
        }
    }
}
