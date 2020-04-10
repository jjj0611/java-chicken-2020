package domain.menu;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MenuRepositoryTest {

    @Test
    void findByIdException() {
        assertThatThrownBy(() -> MenuRepository.findById(100))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void menus() {
        assertThat(MenuRepository.menus()).size().isEqualTo(8);
    }
}