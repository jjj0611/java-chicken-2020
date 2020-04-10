package domain.pay;

import domain.price.Price;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PaymentMethodTest {

    @Test
    void paymentMethod() {
        assertThat(PaymentMethod.of(1)).isEqualTo(PaymentMethod.CREDIT_CARD);
        assertThat(PaymentMethod.of(2)).isEqualTo(PaymentMethod.CASH);
    }

    @Test
    void getDisCount() {
        Price price = Price.of(10000);
        PaymentMethod creditCard = PaymentMethod.CREDIT_CARD;
        assertThat(creditCard.getDisCount(price)).isEqualTo(Price.of(10000));
    }

    @Test
    void paymentMethodException() {
        assertThatThrownBy(() -> PaymentMethod.of(3))
                .isInstanceOf(IllegalArgumentException.class);
    }
}