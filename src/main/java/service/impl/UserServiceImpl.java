package service.impl;

import model.dto.User;
import repository.UserRepository;
import repository.impl.UserRepositoryImpl;
import service.UserService;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserServiceImpl implements UserService {

    final UserRepository userRepository = new UserRepositoryImpl();

    @Override
    public boolean createUser(User user) throws SQLException {
        return userRepository.createUser(user) > 0;
    }

    @Override
    public User getUser(String email) throws SQLException {
        ResultSet resultSet = userRepository.getUser(email);
        if(resultSet.next()){
            return new User(resultSet.getString("first_name"),
                    resultSet.getString("second_name"),
                    resultSet.getString("email"),
                    resultSet.getString("user_password"));
        }
        return null;
    }
}
