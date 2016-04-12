package sample;

public class NextCommand {

    private final Command command;
    private final int index;
    private int tabIndex;

    public NextCommand(Command command, int index, int tabIndex) {
        this.command = command;
        this.index = index;
        this.tabIndex = tabIndex;
    }

    public String getOutputText(String text) {
        String outputText = "";
        switch (command) {
            case TAB:
                outputText = getTabString(tabIndex++) + text.substring(0, index + 1);
                break;
            case NO_TAB:
                outputText = getTabString(tabIndex) + text.substring(0, index + 1);
                break;
            case REVERSE_TAB:
                int adjustedIndex = index == 0 ? index + 1 : index;
                outputText = getTabString(tabIndex--) + text.substring(0, adjustedIndex);
                break;
        }
        return outputText;
    }

    private String getTabString(int tabs) {
        String tabText = "";
        if (tabs > 0) {
            tabText += "\n";
        }
        for (int i = 0; i < tabs && tabs > 0; i++) {
            tabText += "\t";
        }
        return tabText;

    }

    public String getRemainingText(String text) {
        String remainingText;
        switch (command) {
            case REVERSE_TAB:
                int adjustedIndex = index == 0 ? index + 1 : index;
                remainingText = text.substring(adjustedIndex);
                break;
            default:
                remainingText = text.substring(index + 1);
                break;

        }
        return remainingText.trim();
    }

    public int getNewTabIndex() {
        return tabIndex;
    }

    public Command getCommand() {
        return command;
    }
}
