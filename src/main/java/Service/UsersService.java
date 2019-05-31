package Service;

import Domain.Users;
import Persistence.UsersRepository;

import java.sql.SQLException;

public class UsersService {

    private UsersRepository usersRepository=new UsersRepository();

    public void insertUser(String username) throws SQLException {
        usersRepository.insertUser(username);
    }
}
