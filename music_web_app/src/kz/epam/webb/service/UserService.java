package kz.epam.webb.service;

import kz.epam.webb.database.dao.UserDao;
import kz.epam.webb.database.dao.UserDaoImpl;

public class UserService {
    UserDao dao = new UserDaoImpl();

    public boolean checkLogin(String login, String password) {
        return dao.logIn(login, password);
    }

    public boolean checkUserExistence(String login) {
        return dao.findByUsername(login);
    }

    public void addUser(String login, String password, int day, int month, int year, String name, String surname, String gender) {
        dao.createUser(login, password, day, month, year, name, surname, gender);
    }

}

