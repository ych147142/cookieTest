package com.neuedu.service;


import com.neuedu.dao.IUserDao;
import com.neuedu.dao.UserDaoImpl;
import com.neuedu.pojo.User;

public class UserServiceImpl implements IUserService {
    private IUserDao dao = new UserDaoImpl();

    @Override
    public int insert(User user) {
        return dao.insert(user);
    }

    @Override
    public User getOne(String username) {
        return dao.getOne(username);
    }
}
