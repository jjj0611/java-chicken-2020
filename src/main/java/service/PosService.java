package service;

import controller.OrderResponseDto;
import controller.TableResponseDto;
import domain.menu.Menu;
import domain.menu.MenuRepository;
import domain.order.Order;
import domain.order.OrderRepository;
import domain.price.Price;
import domain.table.Table;
import domain.table.TableRepository;

import java.util.List;
import java.util.stream.Collectors;

public class PosService {

    private OrderRepository orderRepository = new OrderRepository();

    public void placeOrder(int tableNumber, int menuNumber, int menuCount) {
        Table table = TableRepository.findById(tableNumber);
        Menu menu = MenuRepository.findById(menuNumber);
        orderRepository.placeOrder(table, menu, menuCount);
    }

    public Price calculatePrice(int tableNumber, int paymentMethod) {
        Table table = TableRepository.findById(tableNumber);
        Order order = orderRepository.findByTable(table);
        return order.calculatePrice(paymentMethod);
    }

    public List<TableResponseDto> getTableResponseDto() {
        return TableRepository.tables()
                .stream()
                .map(table -> new TableResponseDto(table.getNumber(), orderRepository.isEmpty(table)))
                .collect(Collectors.toList());
    }

    public List<OrderResponseDto> getOrderResponseDto(int tableNumber) {
        Table table = TableRepository.findById(tableNumber);
        Order order = orderRepository.findByTable(table);
        return MenuRepository.menus()
                .stream()
                .filter(order::hasMenu)
                .map(menu -> new OrderResponseDto(menu.getName(), order.getCount(menu), order.sumPriceBy(menu)))
                .collect(Collectors.toList());
    }
}
