package repository;

import model.dto.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface UserRepository {
    int createUser(User user) throws SQLException;
    ResultSet getUser(String email) throws SQLException;
}
