package Persistence;

import Domain.Users;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsersRepository {
    public void insertUser(Users users) throws SQLException {
        //dupa ce se realizeaza verificarea in insertCredentials() din clasa LoggedIn,
        //in care se testeaza daca userul si parola exista in baza de date
        //acel user si acea parola
        //sunt introduse de 2 ori in baza de date
        try (Connection connection = DatabaseConfiguration.getConnection()) {
            String insertUser = "INSERT INTO users(`Username`,`Password`) VALUES (?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertUser);
            preparedStatement.setString(1,users.getUsername());
            preparedStatement.setString(2,users.getPassword());
            preparedStatement.executeUpdate();
        }
    }

    public List<Users> getUser() throws SQLException {
        try(Connection connection=DatabaseConfiguration.getConnection()){
            String getUser="SELECT Username,Password from users";
            Statement statement=connection.createStatement();
            statement.execute(getUser);

            ResultSet resultSet=statement.executeQuery(getUser);
            List<Users> utilizatori=new ArrayList<>();
            while(resultSet.next()){
                Users users=new Users();
                users.setUsername(resultSet.getString("Username"));
                users.setPassword(resultSet.getString("Password"));
                utilizatori.add(users);
            }
            return utilizatori;
        }
    }
}
