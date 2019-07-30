package kz.epam.webb.service;

import kz.epam.webb.dao.UserDao;
import kz.epam.webb.dao.UserDaoImpl;

import java.sql.*;
import java.util.Properties;

public class UserService {
    UserDao dao = new UserDaoImpl();

    public boolean checkLogin(String login, String password) {
        return dao.logIn(login, password);
    }

    public boolean checkUserExistence(String login) {
        return dao.findByUsername(login);
    }

    public void addUser(String login, String password) {
        dao.createUser(login, password);
    }

}

