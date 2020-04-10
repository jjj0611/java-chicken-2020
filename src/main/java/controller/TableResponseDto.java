package controller;

public class TableResponseDto {

    private int tableNumber;
    private boolean hasMenu;

    public TableResponseDto(int tableNumber, boolean hasMenu) {
        this.tableNumber = tableNumber;
        this.hasMenu = hasMenu;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public boolean getHasMenu() {
        return hasMenu;
    }
}
