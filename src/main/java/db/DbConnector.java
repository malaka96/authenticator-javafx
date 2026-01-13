package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {
    private static DbConnector dbConnector;
    final Connection connection;

    private DbConnector() throws SQLException {
        connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/authenticator_javafx", "root", "1234");
    }

    public static DbConnector getInstance() throws SQLException {
        if(dbConnector == null) dbConnector = new DbConnector();
        return dbConnector;
    }

    public Connection getConnection(){
        return connection;
    }

}
