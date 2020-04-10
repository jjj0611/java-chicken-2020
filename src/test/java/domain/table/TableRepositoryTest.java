package domain.table;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TableRepositoryTest {

    @Test
    void findByIdException() {
        assertThatThrownBy(() -> TableRepository.findById(9))
                .isInstanceOf(IllegalArgumentException.class);
    }
}