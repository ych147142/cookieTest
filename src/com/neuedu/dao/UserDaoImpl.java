package com.neuedu.dao;


import com.neuedu.pojo.User;
import com.neuedu.utilTest.JdbcUtil;
import com.neuedu.utilTest.RowMap;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements IUserDao {
    @Override
    public int insert(User user) {
        return JdbcUtil.executeUpdate("insert into user(username,password,tele) values(?,?,?)",user.getUsername(),user.getPassword(),user.getTele());
    }

    @Override
    public User getOne(String username) {
        return JdbcUtil.queryOne("select username,password,tele from user where username=?", new RowMap<User>() {
            @Override
            public User RowMapping(ResultSet resultSet) {
                User u = new User();
                try {
                    u.setUsername(resultSet.getString("username"));
                    u.setPassword(resultSet.getString("password"));
                    u.setTele(resultSet.getString("tele"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return u;
            }
        }, username);
    }

}
