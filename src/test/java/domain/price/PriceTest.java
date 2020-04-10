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
}