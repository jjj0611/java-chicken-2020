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

    @Test
    void orderByNumber() {
        Command command = Command.of(1);
        assertThat(command).isEqualTo(Command.ORDER);
    }

    @Test
    void payByNumber() {
        Command command = Command.of(2);
        assertThat(command).isEqualTo(Command.PAY);
    }

    @Test
    void exitByNumber() {
        Command command = Command.of(3);
        assertThat(command).isEqualTo(Command.EXIT);
    }

    @Test
    void exceptionByNumber() {
        assertThatThrownBy(() -> Command.of(4))
                .isInstanceOf(IllegalArgumentException.class);
    }
}