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
}
