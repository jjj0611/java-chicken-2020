package controller;

import domain.command.Command;
import domain.menu.Menu;
import domain.menu.MenuRepository;
import service.PosService;
import view.InputView;
import view.OutputView;

import java.util.List;

public class PosController {

    private PosService posService = new PosService();
    private boolean exit = false;

    public void run() {
        while (!exit) {
            runCommand();
        }
    }

    private void runCommand() {
        try {
            int commandNumber = InputView.inputCommandNumber();
            Command command = Command.of(commandNumber);
            switch (command) {
                case ORDER:
                    order();
                    break;
                case PAY:
                    pay();
                    break;
                case EXIT:
                    exit();
                    break;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void order() {
        OutputView.printTables(posService.getTableResponseDto());
        final int tableNumber = InputView.inputTableNumber();
        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);
        final int menuNumber = InputView.inputMenuNumber();
        final int menuCount = InputView.inputMenuCount();
        posService.placeOrder(tableNumber, menuNumber, menuCount);
    }

    private void pay() {
    }

    private void exit() {
        exit = true;
    }

}
