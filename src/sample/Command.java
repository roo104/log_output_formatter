package sample;

public enum Command {

    NO_TAB(','),
    TAB('{'),
    REVERSE_TAB('}');

    private final char c;

    Command(char c) {
        this.c = c;
    }

    public char getC() {
        return c;
    }

}
