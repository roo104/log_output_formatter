package sample;

import java.util.HashMap;
import java.util.Map;

public class LogFormatter {

    private String text;
    private String finalText = "";

    public LogFormatter(String text) {
        this.text = "CreatePrintCommand{documentName=null, documentMetaDataCqCollection=[], printContextCq=PrintContextCq{printTemplateArgumentContextCqCollection=[], printTemplateSelectionCqCollection=[PrintTemplateSelectionCq{childTemplateCollection=[], printTemplateVersionIdCq=PrintTemplateVersionIdCq{uniqueId=$JDogK9VZQL@6mkw93Q, printTemplateIdCq=PrintTemplateIdCq{uniqueId=$JDogK9VZQK$RfqLU4T, templateId=Tom_Email}}, printTemplateSelectionEditCq=null}], printContextElementCqCollection=[], selectedOutputChannel=Central Print, defaultOutputChannel=null}}";
    }

    public String prettyPrint() {
        int tabIndex = 0;

        while (text.length() > 0) {
            NextCommand command = getNextCommand(text, tabIndex);
            finalText += command.getOutputText(text);
            text = command.getRemainingText(text);
            tabIndex = command.getNewTabIndex();

            System.out.println("NextCmd:\t" + command.getCommand());
            System.out.println("FinalText:\t" + finalText);
            System.out.println("Text:\t\t" + text);
            System.out.println("TabIndex:\t" + tabIndex);
            System.out.println("==========================================================");
        }

        return finalText;
    }

    private NextCommand getNextCommand(String finalText, int currentIndex) {
        int tabIndex = finalText.indexOf(Command.TAB.getC());
        int noTabIndex = finalText.indexOf(Command.NO_TAB.getC());
        int reverseTab = finalText.indexOf(Command.REVERSE_TAB.getC());

        Command cmd = null;

        int lowestValue = Integer.MAX_VALUE;

        Map<Command, Integer> integers = new HashMap<>();
        integers.put(Command.TAB, tabIndex);
        integers.put(Command.NO_TAB, noTabIndex);
        integers.put(Command.REVERSE_TAB, reverseTab);

        for (Map.Entry<Command, Integer> entry : integers.entrySet()) {
            if (entry.getValue() >= 0 && entry.getValue() < lowestValue) {
                lowestValue = entry.getValue();
                cmd = entry.getKey();
            }
        }

        return new NextCommand(cmd, lowestValue, currentIndex);
    }

}
