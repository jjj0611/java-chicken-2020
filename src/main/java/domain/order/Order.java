package domain.order;

import domain.menu.Menu;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private static final int MAX_ORDER_COUNT = 100;
    private static final int MINIMUM_COUNT = 0;
    private static final int NOT_EXISTING_COUNT = 0;

    private Map<Menu, Integer> menuCount = new HashMap<>();

    public void add(Menu menu, int additionalCount) {
        validateMenuCount(menu, additionalCount);
        validateTotalMenuCount(additionalCount);
        menuCount.computeIfPresent(menu, (key, value) -> value + additionalCount);
        menuCount.putIfAbsent(menu, additionalCount);
    }

    public boolean isEmpty() {
        int totalCount = menuCount.values()
                .stream()
                .reduce(Integer::sum)
                .orElse(0);
        return totalCount == NOT_EXISTING_COUNT;
    }

    private void validateMenuCount(Menu menu, int additionalCount) {
        if (menuCount.containsKey(menu) && menuCount.get(menu) + additionalCount < MINIMUM_COUNT) {
            throw new IllegalArgumentException("메뉴 개수는 음수일 수 없습니다.");
        }
        if (!menuCount.containsKey(menu) && additionalCount < MINIMUM_COUNT) {
            throw new IllegalArgumentException("메뉴 개수는 음수일 수 없습니다.");
        }
    }

    private void validateTotalMenuCount(int additionalCount) {
        int totalCount = menuCount.values()
                .stream()
                .reduce(Integer::sum)
                .orElse(0);
        if (totalCount + additionalCount >= MAX_ORDER_COUNT) {
            throw new IllegalArgumentException("주문은 최대 99개까지 가능합니다.");
        }
    }
}
