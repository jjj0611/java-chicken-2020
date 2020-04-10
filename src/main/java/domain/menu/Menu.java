package domain.menu;

import domain.price.Price;

public class Menu {
    private final int number;
    private final String name;
    private final Category category;
    private final Price price;

    public Menu(final int number, final String name, final Category category, final Price price) {
        this.number = number;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    @Override
    public String toString() {
        return category + " " + number + " - " + name + " : " + price.getValue() + "원";
    }

    public boolean isChicken() {
        return category.equals(Category.CHICKEN);
    }

    public String getName() {
        return name;
    }

    public Price getPrice() {
        return price;
    }
}
