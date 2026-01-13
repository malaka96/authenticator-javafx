package service.impl;

import model.dto.User;
import repository.UserRepository;
import repository.impl.UserRepositoryImpl;
import service.UserService;
import utils.EmailValidator;
import utils.PasswordUtil;
import utils.PasswordValidator;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserServiceImpl implements UserService {

    final UserRepository userRepository = new UserRepositoryImpl();

    @Override
    public boolean createUser(User user) throws Exception {

        if(!EmailValidator.isValidEmail(user.getEmail())){
            throw new RuntimeException("Invalid Email");
        }

        PasswordValidator.validate(user.getPassword());

        String hashedPassword = PasswordUtil.hashPassword(user.getPassword());
        User securedUser = new User(user.getFirstName(),user.getLastName(),user.getEmail(),hashedPassword);
        return userRepository.createUser(securedUser) > 0;
    }

    @Override
    public boolean getUser(String email, String password) throws Exception {
        ResultSet resultSet = userRepository.getUser(email);
        if(resultSet.next()){
            if(email.equals(resultSet.getString("email"))
                    && PasswordUtil.verifyPassword(password,resultSet.getString("user_password"))){
                return true;
            }
        }
        return false;
    }
}
