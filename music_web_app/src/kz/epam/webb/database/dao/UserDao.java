package kz.epam.webb.database.dao;

public interface UserDao {

    //boolean find(String email) throws SQLException;

    //void add(Account account);

    boolean logIn(String login, String password);
    boolean findByUsername(String login);
    void createUser(String login, String password, int day, int month, int year, String name, String surname, String gender);
}
