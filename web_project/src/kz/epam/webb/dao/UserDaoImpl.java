package kz.epam.webb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    private static final String SELECT_LOGIN_ACCOUNT = "Select login, password From userinfo where login = ? and password = ?";
    private static final String SELECT_LOGIN = "Select login From userinfo where login = ?";
    public static final String CREATE_USER = "INSERT INTO userinfo(login, password) VALUES  (?, ?)";
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

    public void createUser(String login, String password) {
        connection = ConnectionPool.INSTANCE.takeConnection();
        try (PreparedStatement statement = connection.prepareStatement(CREATE_USER)) {
            statement.setString(1, login);
            statement.setString(2, password);
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
