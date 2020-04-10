package domain.order;

import domain.menu.Menu;
import domain.menu.MenuRepository;
import domain.pay.PaymentMethod;
import domain.price.Price;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OrderTest {

    @Test
    void order() {
        Order order = Order.empty();
        Menu menu = MenuRepository.findById(1);
        order.add(menu, 3);
        assertThat(order);
    }

    @Test
    void menuCountException() {
        Order order = Order.empty();
        Menu menu = MenuRepository.findById(1);
        assertThatThrownBy(() -> order.add(menu, -1))
                .isInstanceOf(IllegalArgumentException.class);
        order.add(menu, 1);
        assertThatThrownBy(() -> order.add(menu, -2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void orderTotalCountException() {
        Order order = Order.empty();
        Menu firstMenu = MenuRepository.findById(1);
        Menu secondMenu = MenuRepository.findById(2);
        order.add(firstMenu, 10);
        assertThatThrownBy(() -> order.add(secondMenu, 90))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> order.add(firstMenu, 90))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void orderHasMenu() {
        Order order = Order.empty();
        Menu menu = MenuRepository.findById(1);
        assertThat(order.hasMenu(menu)).isFalse();
    }

    @Test
    void orderMenuCount() {
        Order order = Order.empty();
        Menu menu = MenuRepository.findById(1);
        order.add(menu, 1);
        assertThat(order.getCount(menu)).isEqualTo(1);
    }

    @Test
    void orderSumPriceByMenu() {
        Order order = Order.empty();
        Menu menu = MenuRepository.findById(1);
        order.add(menu, 3);
        assertThat(order.sumPriceBy(menu)).isEqualTo(48000);
    }

    @Test
    void isEmpty() {
        Order order = Order.empty();
        assertThat(order.isEmpty()).isTrue();
    }

    @Test
    void calculatePrice() {
        Order order = Order.empty();
        Menu menu = MenuRepository.findById(1);
        order.add(menu, 10);
        assertThat(order.calculatePrice(PaymentMethod.CASH)).isEqualTo(Price.of(142500));
    }
}