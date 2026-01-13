package service;

import model.dto.User;

import java.sql.SQLException;

public interface UserService {
    boolean createUser(User user) throws Exception;
    boolean getUser(String email,String password) throws Exception;
}
