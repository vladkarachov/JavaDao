package cashMachine.daoFactory.postgres.implem;

import cashMachine.dao.itemDao;
import cashMachine.entities.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IItemDao implements itemDao {
    Connection conn=null;


    public IItemDao(Connection conn) {
        this.conn = conn;
    }


    @Override
    public void add(Item item) {

        String insert_q = "Insert into items ( id, name, weight, price) values (nextval('items_seq'), ";
        insert_q+=item.toStringQuery()+')';
        try {
            Statement statement = conn.createStatement();
            statement.execute(insert_q);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Item> getAll() {
        String insert_q = "Select * from items";
        ArrayList<Item> items = new ArrayList<>();
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet  = statement.executeQuery(insert_q);
            while (resultSet.next()){
                Item item = new Item( resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getFloat(3),
                        resultSet.getFloat(4)
                );
                items.add(item);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return items;
    }

    @Override
    public Item get(long id) {
        String get_q = "Select * from items where id = " + id;
        return getItem(get_q);
    }

    @Override
    public Item get(String name) {
        String get_q = "Select * from items where name like '%" + name+"%'";
        return getItem(get_q);
    }


    @Override
    public void delete(Item item) {
        String delete_q = "delete from items where  id = " + item.id;
        try {
            Statement statement = conn.createStatement();
            statement.execute(delete_q);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Item item) {
        String update_q = "update items " +
                "set name = '" + item.name+"'"+
                " , weight = " + item.weight+
                " ,price = " + item.price+
                " where  id = " + item.id;
        try {
            Statement statement = conn.createStatement();
            statement.execute(update_q);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private Item getItem(String select_q) {
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(select_q);
            if (resultSet.next()){
            Item item = new Item(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getFloat(3),
                    resultSet.getFloat(4)
            );

            return item;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
