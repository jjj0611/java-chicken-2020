package domain.command;

import java.util.Arrays;

public enum Command {

    ORDER(1),
    PAY(2),
    EXIT(3);

    private int number;

    Command(int number) {
        this.number = number;
    }

    public static Command of(String name) {
        try {
            name = name.trim();
            return valueOf(name.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("잘못된 명령어입니다.");
        }
    }

    public static Command of(int number) {
        return Arrays.stream(values())
                .filter(command -> command.number == number)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 번호를 입력하셨습니다."));
    }
}
