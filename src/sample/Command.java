package sample;

public enum Command {

    NO_TAB(','),
    TAB('{'),
    REVERSE_TAB('}');

    private final char c;

    Command(char c) {
        this.c = c;
    }

    public static Command fromChar(char c) {
        Command value = null;
        for (Command command : Command.values()) {
            if (command.c == c) {
                value = command;
                break;
            }
        }
        return value;
    }

    public char getC() {
        return c;
    }

}
