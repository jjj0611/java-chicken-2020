package domain.order;

import domain.menu.Menu;
import domain.menu.MenuRepository;
import domain.table.Table;
import domain.table.TableRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OrderRepositoryTest {

    private OrderRepository orderRepository;

    @BeforeEach
    void setUp() {
        orderRepository = new OrderRepository();
    }

    @Test
    void placeOrder() {
        Table table = TableRepository.findById(1);
        Menu menu = MenuRepository.findById(1);
        orderRepository.placeOrder(table, menu, 10);
        Order order = orderRepository.findByTable(table);
        assertThat(order.getCount(menu)).isEqualTo(10);
    }

    @Test
    void isEmpty() {
        Table table = TableRepository.findById(1);
        assertThat(orderRepository.isEmpty(table)).isTrue();
    }

    @Test
    void initialize() {
        Table table = TableRepository.findById(1);
        Menu menu = MenuRepository.findById(1);
        orderRepository.placeOrder(table, menu, 10);
        orderRepository.initialize(table);
        assertThat(orderRepository.isEmpty(table)).isTrue();
    }
}