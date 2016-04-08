package sample;

public class LogFormatter {

    private String text;
    private String finalText = "";

    public LogFormatter(String text) {
        this.text = "CreatePrintCommand{documentName=null, documentMetaDataCqCollection=[], printContextCq=PrintContextCq{printTemplateArgumentContextCqCollection=[], printTemplateSelectionCqCollection=[PrintTemplateSelectionCq{childTemplateCollection=[], printTemplateVersionIdCq=PrintTemplateVersionIdCq{uniqueId=$JDogK9VZQL@6mkw93Q, printTemplateIdCq=PrintTemplateIdCq{uniqueId=$JDogK9VZQK$RfqLU4T, templateId=Tom_Email}}, printTemplateSelectionEditCq=null}], printContextElementCqCollection=[], selectedOutputChannel=Central Print, defaultOutputChannel=null}}";
    }

    public String prettyPrint() {
        int tabIndex = 0;

        while (text.length() > 1) {
            NextCommand command = getNextCommand(text, tabIndex);
            finalText += command.getOutputText(text);
            text = command.getRemainingText(text);
            tabIndex = command.getNewTabIndex();
        }

        return finalText;
    }

    private NextCommand getNextCommand(String finalText, int currentIndex) {
        int tabIndex = finalText.indexOf(Command.TAB.getC());
        int noTabIndex = finalText.indexOf(Command.NO_TAB.getC());
        int reverseTab = finalText.indexOf(Command.REVERSE_TAB.getC());

        Command cmd = null;
        int index = tabIndex;

        int lowestValue = Integer.MAX_VALUE;

        if (tabIndex > 0 && tabIndex < lowestValue) {
            cmd = Command.TAB;
            index = tabIndex;
        } else if (noTabIndex > 0 && noTabIndex < lowestValue && noTabIndex < reverseTab) {
            cmd = Command.NO_TAB;
            index = noTabIndex;
        } else if (reverseTab < lowestValue) {
            cmd = Command.REVERSE_TAB;
            index = reverseTab;
        }

        return new NextCommand(cmd, index, currentIndex);
    }


}
