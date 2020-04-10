package domain.price;

public class Price {
    private static final int MINIMUM_PRICE = 0;
    private final int value;

    private Price(int value) {
        validatePrice(value);
        this.value = value;
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
}
