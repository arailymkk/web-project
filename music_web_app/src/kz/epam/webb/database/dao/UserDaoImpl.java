package kz.epam.webb.database.dao;

import kz.epam.webb.database.connectionpool.ConnectionPool;
import kz.epam.webb.database.dao.UserDao;

import java.sql.*;

public class UserDaoImpl implements UserDao {
    public static void main(String[] args) {
        UserDao dao = new UserDaoImpl();
        dao.createUser("yyu", "poi", 2, 5, 1998, "nin", "tin", "F");
    }


    private static final String SELECT_LOGIN_ACCOUNT = "Select login, password From userinfo where login = ? and password = ?";
    private static final String SELECT_LOGIN = "Select login From userinfo where login = ?";
    public static final String CREATE_USER = "INSERT INTO userinfo(login, password, birthday, username, surname, gender) VALUES  (?, ?, ?, ?, ?, ?)";
    //private ConnectionPool connectionPool = ConnectionPool.INSTANCE;
    private Connection connection;

    private boolean accountExists = false;

    @Override
    public boolean logIn(String login, String password) {
        boolean userLoginCombinationExists = false;
        //connection = connectionPool.takeConnection();
        connection = ConnectionPool.INSTANCE.takeConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LOGIN_ACCOUNT)) {
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.first()) {
                userLoginCombinationExists = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                ConnectionPool.INSTANCE.releaseConnection(connection);
            }
        }
        return userLoginCombinationExists;
    }

    @Override
    public boolean findByUsername(String login) {
        boolean userExists = false;
        connection = ConnectionPool.INSTANCE.takeConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LOGIN)) {
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.first()) {
                userExists = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                ConnectionPool.INSTANCE.releaseConnection(connection);
            }
        }
        return userExists;
    }

    public void createUser(String login, String password, int day, int month, int year, String name, String surname, String gender) {
        connection = ConnectionPool.INSTANCE.takeConnection();
        try (PreparedStatement statement = connection.prepareStatement(CREATE_USER)) {
            String stringDate = year + "-" + month + "-" + day;
            //Date date = new SimpleDateFormat("yyyy.MM.dd").parse(stringDate);
            java.sql.Date date = java.sql.Date.valueOf(stringDate);
            statement.setString(1, login);
            statement.setString(2, password);
            statement.setDate(3, date);
            statement.setString(4, name);
            statement.setString(5, surname);
            statement.setString(6, gender);
            statement.executeUpdate();

        } catch (SQLException e) {
            //throw new DAOException("Create user error ", e);
            e.printStackTrace();
        } finally {
            if (connection != null) {
                ConnectionPool.INSTANCE.releaseConnection(connection);
            }
        }
    }
}
