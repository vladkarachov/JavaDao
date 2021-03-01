package cashMachine.dao;

import cashMachine.entities.Item;

import java.util.List;

public interface itemDao {
    void add(Item Item);

    List<Item> getAll();

    Item get(long id);

    Item get(String name);

    void delete(Item item);

    void update(Item item);
}
