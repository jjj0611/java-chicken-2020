package view;

import controller.OrderResponseDto;
import controller.TableResponseDto;
import domain.menu.Menu;
import domain.price.Price;

import java.util.List;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE_FORMAT = "└ %s ┘";
    private static final String ORDER_FORMAT = "%s %d %d\n";

    public static void printTables(final List<TableResponseDto> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printBottomLine(tables);
        System.out.println();
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
        System.out.println();
    }

    private static void printLine(final String line, final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(line);
        }
        System.out.println();
    }

    private static void printBottomLine(final List<TableResponseDto> tables) {
        for (TableResponseDto table : tables) {
            String bottomSymbol = getSymbol(table.getHasMenu());
            System.out.printf(BOTTOM_LINE_FORMAT, bottomSymbol);
        }
        System.out.println();
    }

    private static void printTableNumbers(final List<TableResponseDto> tables) {
        for (final TableResponseDto table : tables) {
            System.out.printf(TABLE_FORMAT, table.getTableNumber());
        }
        System.out.println();
    }

    private static String getSymbol(final boolean isEmpty) {
        if (isEmpty) {
            return "-";
        }
        return "₩";
    }

    public static void printOrders(List<OrderResponseDto> orders) {
        System.out.println("메뉴 수량 금액");
        for (OrderResponseDto order : orders) {
            System.out.printf(ORDER_FORMAT, order.getMenu(), order.getCount(), order.getPrice());
        }
    }

    public static void printPrice(Price price) {
        System.out.println("## 최종 결제할 금액");
        System.out.println(price.getValue() + "원");
    }
}
