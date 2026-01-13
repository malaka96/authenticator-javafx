package repository.impl;

import db.DbConnector;
import model.dto.User;
import repository.UserRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepositoryImpl implements UserRepository {
    @Override
    public int createUser(User user) throws SQLException {
        Connection connection = DbConnector.getInstance().getConnection();
        String sql = "Insert into users (first_name,second_name,email,user_password) values (?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1,user.getFirstName());
        preparedStatement.setObject(2,user.getLastName());
        preparedStatement.setObject(3,user.getEmail());
        preparedStatement.setObject(4,user.getPassword());
        return preparedStatement.executeUpdate();

    }
}
