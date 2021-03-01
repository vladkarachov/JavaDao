package cashMachine.daoFactory;

import cashMachine.daoFactory.postgres.implem.IItemDao;
import cashMachine.daoFactory.postgres.implem.IUserDao;

import java.sql.Connection;
import java.sql.SQLException;

public class Factory {
    Connection conn=null;
    String connString="jdbc:postgresql://localhost:5432/postgres?user=postgres&password=root";



    public Factory(String connString) {
        }

    public Factory() {

    }

    public IUserDao getUserDao() throws SQLException {return new IUserDao(conn);}
    public IItemDao getItemDao() throws SQLException {
        return new IItemDao(conn);
    }
}
