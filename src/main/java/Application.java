import controller.PosController;

public class Application {
    public static void main(String[] args) {
//        final List<Table> tables = TableRepository.tables();
//        OutputView.printTables(tables);
//
//        final int tableNumber = InputView.inputTableNumber();
//
//        final List<Menu> menus = MenuRepository.menus();
//        OutputView.printMenus(menus);
        PosController posController = new PosController();
        posController.run();
    }
}
