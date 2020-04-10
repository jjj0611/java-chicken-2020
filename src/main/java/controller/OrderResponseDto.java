package controller;

public class OrderResponseDto {
    private String menu;
    private int count;
    private int price;

    public OrderResponseDto(String menu, int count, int price) {
        this.menu = menu;
        this.count = count;
        this.price = price;
    }

    public String getMenu() {
        return menu;
    }

    public int getCount() {
        return count;
    }

    public int getPrice() {
        return price;
    }
}
