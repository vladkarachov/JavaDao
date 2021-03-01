package cashMachine.daoFactory.postgres.implem;

import cashMachine.daoFactory.Factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresFactory extends Factory{
    Connection conn;
    String conn_string="jdbc:postgresql://localhost/?user=postgres&password=root";


    public PostgresFactory(String conn_string) throws SQLException {
        if(!conn_string.isEmpty()){
            this.conn_string=conn_string;
        }
        this.conn = DriverManager.getConnection(this.conn_string);
    }

    @Override
    public IUserDao getUserDao() throws SQLException {
        return new IUserDao(conn);
    }
    @Override
    public IItemDao getItemDao() throws SQLException {
        return new IItemDao(conn);
    }
}
