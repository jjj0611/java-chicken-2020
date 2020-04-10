package domain.pay;

import domain.price.Price;

import java.util.Arrays;

public enum PaymentMethod {

    CREDIT_CARD(1, 1),
    CASH(0.95, 2);

    private double priceRate;
    private int number;

    PaymentMethod(double priceRate, int number) {
        this.priceRate = priceRate;
        this.number = number;
    }

    public static PaymentMethod of(int number) {
        return Arrays.stream(values())
                .filter(method -> method.number == number)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 결제 수단을 입력하셨습니다."));
    }

    public Price getDisCount(Price totalPrice) {
        return totalPrice.multiply(priceRate);
    }
}
