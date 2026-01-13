package service;

import model.dto.User;

import java.sql.SQLException;

public interface UserService {
    boolean createUser(User user) throws SQLException;
    User getUser(String email) throws SQLException;
}
