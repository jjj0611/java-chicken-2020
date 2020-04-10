package domain.command;

public enum Command {

    ORDER,
    PAY,
    EXIT;

    public static Command of(String name) {
        try {
            name = name.trim();
            return valueOf(name.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("잘못된 명령어입니다.");
        }
    }
}
