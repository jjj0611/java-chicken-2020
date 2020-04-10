package domain.order;

import domain.menu.Menu;
import domain.table.Table;
import domain.table.TableRepository;

import java.util.HashMap;
import java.util.Map;

public class OrderRepository {

    private static Map<Table, Order> TABLE_ORDERS = new HashMap<>();

    static {
        for (Table table : TableRepository.tables()) {
            TABLE_ORDERS.put(table, Order.empty());
        }
    }

    public void placeOrder(Table table, Menu menu, int menuCount) {
        Order order = TABLE_ORDERS.get(table);
        order.add(menu, menuCount);
    }

    public boolean isEmpty(Table table) {
        Order order = TABLE_ORDERS.get(table);
        return order.isEmpty();
    }

    public Order findByTable(Table table) {
        return TABLE_ORDERS.get(table);
    }

    public void initialize(Table table) {
        TABLE_ORDERS.put(table, Order.empty());
    }
}
