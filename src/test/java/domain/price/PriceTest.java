package domain.price;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PriceTest {

    @Test
    void price() {
        Price price = Price.of(10000);
        assertThat(price.getValue()).isEqualTo(10000);
    }

    @Test
    void priceException() {
        assertThatThrownBy(() -> Price.of(-10000))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void plus() {
        Price tenThousandPrice = Price.of(10000);
        Price fiveThousandPrice = Price.of(5000);
        assertThat(tenThousandPrice.plus(fiveThousandPrice)).isEqualTo(Price.of(15000));
    }

    @Test
    void minus() {
        Price tenThousandPrice = Price.of(10000);
        Price fiveThousandPrice = Price.of(5000);
        assertThat(tenThousandPrice.minus(fiveThousandPrice)).isEqualTo(Price.of(5000));
    }

    @Test
    void multiply() {
        Price tenThousandPrice = Price.of(10000);
        assertThat(tenThousandPrice.multiply(3)).isEqualTo(Price.of(30000));
        assertThat(tenThousandPrice.multiply(0.95)).isEqualTo(Price.of(9500));
    }
}