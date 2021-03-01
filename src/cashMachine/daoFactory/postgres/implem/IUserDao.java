package cashMachine.daoFactory.postgres.implem;

import cashMachine.dao.userDao;
import cashMachine.entities.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class IUserDao implements userDao {
    Connection conn=null;

    public IUserDao(Connection conn) {
        this.conn = conn;
    }

    @Override
    public ArrayList<User> getAll() {
        String insert_q = "Select * from users";
        ArrayList<User> users = new ArrayList<>();
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet  = statement.executeQuery(insert_q);
            while (resultSet.next()){
                User User = new User( resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getString(3),
                        resultSet.getString(4)
                );
                users.add(User);

            }
            //todo
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }


    @Override
    public User get(long id) {
        String insert_q = "Select * from users where id = " + id;
        return getItem(insert_q);
    }

    @Override
    public User get(String login) {
        String insert_q = "Select * from users where login = '" + login+"'";
        return getItem(insert_q);
    }


    private User getItem(String select_q) {
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(select_q);
            if(resultSet.next()) {
                User User = new User(resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getString(3),
                        resultSet.getString(4)
                );
                return User;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public User changePassword(User User, String new_pass) {
        String update_q="update users set password = ";
        update_q+="'"+new_pass+"'";
        update_q+=" where id = ";
        update_q+=User.id;
        try {
            Statement statement = conn.createStatement();
            statement.executeQuery(update_q);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return get(User.id);
    }
}
