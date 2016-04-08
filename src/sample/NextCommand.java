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
                outputText = getTabString(tabIndex--) + text.substring(0, index + 1);
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
        return text.substring(index + 1);
    }

    public int getNewTabIndex() {
        return tabIndex;
    }
}
