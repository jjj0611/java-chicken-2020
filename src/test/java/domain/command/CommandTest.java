package domain.command;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CommandTest {

    @Test
    void order() {
        Command command = Command.of("order");
        assertThat(command).isEqualTo(Command.ORDER);
    }

    @Test
    void pay() {
        Command command = Command.of("pay");
        assertThat(command).isEqualTo(Command.PAY);
    }

    @Test
    void exit() {
        Command command = Command.of("exit");
        assertThat(command).isEqualTo(Command.EXIT);
    }

    @Test
    void exception() {
        assertThatThrownBy(() -> Command.of("hi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 명령어입니다.");
    }
}