package cashMachine.dao;

import cashMachine.entities.User;

import java.util.List;

public interface userDao {
    List<User> getAll();

    User get(long id);

    User get(String login);

    User changePassword(User User, String new_pass);

}
