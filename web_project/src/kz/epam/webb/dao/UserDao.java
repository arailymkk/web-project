package kz.epam.webb.dao;

import java.sql.SQLException;

public interface UserDao {

    //boolean find(String email) throws SQLException;

    //void add(Account account);

    boolean logIn(String login, String password);
    boolean findByUsername(String login);
    void createUser(String login, String password);
}
