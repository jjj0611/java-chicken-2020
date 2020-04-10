package service;

import controller.TableResponseDto;
import domain.menu.Menu;
import domain.menu.MenuRepository;
import domain.order.OrderRepository;
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

    public List<TableResponseDto> getTableResponseDto() {
        return TableRepository.tables()
                .stream()
                .map(table -> new TableResponseDto(table.getNumber(), orderRepository.isEmpty(table)))
                .collect(Collectors.toList());
    }
}
