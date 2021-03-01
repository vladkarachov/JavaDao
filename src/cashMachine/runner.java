package cashMachine;

import cashMachine.daoFactory.Factory;
import cashMachine.daoFactory.postgres.implem.IItemDao;
import cashMachine.daoFactory.postgres.implem.IUserDao;
import cashMachine.daoFactory.postgres.implem.PostgresFactory;
import cashMachine.entities.Item;
import cashMachine.entities.User;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
public class runner {

public static void main(String[] args) throws Exception {
    Factory test = new PostgresFactory("");
    IItemDao itemdao = test.getItemDao();
    itemdao.add(new Item("Moloko", 0.5F, 10));
    Item testItem = itemdao.get(3);
    System.out.println(testItem.toStringQuery());
    testItem.price=100;
    itemdao.update(testItem);
    System.out.println(itemdao.get(3).toStringQuery());
    itemdao.delete(testItem);

}
}
