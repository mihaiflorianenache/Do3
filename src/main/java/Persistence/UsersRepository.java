package Persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsersRepository {
    public void insertUser(String username) throws SQLException {
        try (Connection connection = DatabaseConfiguration.getConnection()) {
            String insertUser = "INSERT INTO users(`Username`) VALUES (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertUser);
            preparedStatement.setString(1,username);
            preparedStatement.executeUpdate();
        }
    }
}
