package domain.order;

import domain.menu.Menu;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private static final int MAX_ORDER_COUNT = 100;

    private Map<Menu, Integer> menuCount = new HashMap<>();

    public void add(Menu menu, int count) {
        menuCount.computeIfPresent(menu, (key, value) -> value + count);
        menuCount.putIfAbsent(menu, count);
        int totalCount = menuCount.values()
                .stream()
                .reduce(Integer::sum)
                .orElse(0);
        if (totalCount >= MAX_ORDER_COUNT) {
            throw new IllegalArgumentException("주문은 최대 99개까지 가능합니다.");
        }
    }
}
