package domain.price;

public class Price {
    private static final int MINIMUM_PRICE = 0;
    private final int value;

    private Price(int value) {
        validatePrice(value);
        this.value = value;
    }

    private Price(double value) {
        this((int) value);
    }

    public static Price of(int value) {
        return new Price(value);
    }

    private void validatePrice(int price) {
        if (price < MINIMUM_PRICE) {
            throw new IllegalArgumentException("가격은 음수일 수 없습니다.");
        }
    }

    public int getValue() {
        return value;
    }

    public Price multiply(int number) {
        return new Price(value * number);
    }

    public Price multiply(double number) {
        return new Price(value * number);
    }

    public Price plus(Price price) {
        return new Price(this.value + price.value);
    }

    public Price minus(Price price) {
        return new Price(this.value - price.value);
    }
}
