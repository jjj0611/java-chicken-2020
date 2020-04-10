package domain.order;

import domain.menu.Menu;
import domain.menu.MenuRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OrderTest {

    @Test
    void order() {
        Order order = new Order();
        Menu menu = MenuRepository.findById(1);
        order.add(menu, 3);
        assertThat(order);
    }

    @Test
    void orderException() {
        Order order = new Order();
        Menu menu = MenuRepository.findById(1);
        assertThatThrownBy(() -> order.add(menu, 100))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void multipleOrderException() {
        Order order = new Order();
        Menu firstMenu = MenuRepository.findById(1);
        Menu secondMenu = MenuRepository.findById(2);
        order.add(firstMenu, 10);
        assertThatThrownBy(() -> order.add(secondMenu, 90))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> order.add(firstMenu, 90))
                .isInstanceOf(IllegalArgumentException.class);
    }
}