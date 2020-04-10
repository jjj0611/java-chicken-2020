package domain.order;

import domain.menu.Menu;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private static final int MAX_ORDER_COUNT = 100;
    private static final int MINIMUM_COUNT = 0;

    private Map<Menu, Integer> menuCount = new HashMap<>();

    public void add(Menu menu, int count) {
        menuCount.computeIfPresent(menu, (key, value) -> value + count);
        menuCount.putIfAbsent(menu, count);
        validateMenuCount(menu);
        validateTotalMenuCount();
    }

    private void validateMenuCount(Menu menu) {
        if (menuCount.get(menu) < MINIMUM_COUNT) {
            throw new IllegalArgumentException("메뉴 개수는 음수일 수 없습니다.");
        }
    }

    private void validateTotalMenuCount() {
        int totalCount = menuCount.values()
                .stream()
                .reduce(Integer::sum)
                .orElse(0);
        if (totalCount >= MAX_ORDER_COUNT) {
            throw new IllegalArgumentException("주문은 최대 99개까지 가능합니다.");
        }
    }
}
