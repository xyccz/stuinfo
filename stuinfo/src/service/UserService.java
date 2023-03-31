package service;

import dao.UserDao;
import domain.User;

import java.sql.SQLException;


public class UserService {

    //用户注册
    public boolean register(String userName, String password) {
        UserDao userDao = new UserDao();
        boolean b = userDao.checkUser(userName);
        if (b) {
            boolean b1 = userDao.register(userName, password);
            return true;
        }
        return false;
    }

    //用户登录
    public User userLogin(String userName, String password) {
        UserDao userDao = new UserDao();
        try {
            return userDao.login(userName, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
