package com.jpdevelopment.blogspot;

import java.util.StringTokenizer;

public class Parser {

    private final String text;

    public Parser(String text) {
        this.text = text;
    }

    public String print() {
        StringTokenizer tokenizer = new StringTokenizer(text, "\\{\\}\\[\\]\\,", true);
        StringBuilder sb = new StringBuilder();
        int tabIndex = 0;

        while (tokenizer.hasMoreElements()) {
            String s = ((String) tokenizer.nextElement()).trim();
            switch (s) {
                case "[":
                    sb.append(s);
                    sb.append("\n");
                    tabIndex++;
                    break;
                case "{":
                    sb.append("\n");
                    sb.append(tabs(tabIndex));
                    sb.append(s);
                    sb.append("\n");
                    tabIndex++;
                    break;
                case "]":
                    sb.append("\n");
                    tabIndex--;
                    sb.append(tabs(tabIndex));
                    sb.append(s);
                    break;
                case "}":
                    sb.append("\n");
                    tabIndex--;
                    sb.append(tabs(tabIndex));
                    sb.append(s);
                    break;
                case ",":
                    sb.append(s);
                    sb.append("\n");
                    break;
                default:
                    sb.append(tabs(tabIndex));
                    sb.append(s);
                    break;
            }
        }
        return sb.toString();
    }

    private static String tabs(int numberOfTabs) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberOfTabs; i++) {
            sb.append("\t");
        }
        return sb.toString();
    }
}
