package com.jpdevelopment.blogspot;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Controller extends Frame {

    private final TextArea textArea;
    private final Button printButton;
    private final Button printAsJsonButton;
    private final Button clearButton;
    private final TextField textField;

    public Controller() {
        textArea = setupTextArea();
        printButton = setupPrintButton();
        printAsJsonButton = setupPrintJsonButton();
        clearButton = setupClearButton();
        textField = setupInputTextField();

        setupCloseWindowEvent();
        setupFrame(textArea, printButton, printAsJsonButton, clearButton, textField);
    }

    private TextField setupInputTextField() {
        TextField textField = new TextField(100);
        textField.setBounds(25, 50, 450, 25);
        return textField;
    }

    private TextArea setupTextArea() {
        TextArea textArea = new TextArea();
        textArea.setBounds(25, 150, 750, 625);
        return textArea;
    }

    private Button setupPrintButton() {
        Button b = new Button("Pretty print");
        b.setBounds(25, 100, 100, 25);
        b.addActionListener(e -> textArea.setText(new Parser(textField.getText()).print()));
        return b;
    }

    private Button setupPrintJsonButton() {
        Button b = new Button("Pretty print as JSON");
        b.setBounds(175, 100, 125, 25);
        b.addActionListener(e -> textArea.setText(new Parser(textField.getText()).printAsJson()));
        return b;
    }

    private Button setupClearButton() {
        Button b = new Button("Clear");
        b.setBounds(500, 50, 100, 25);
        b.addActionListener(e -> textField.setText(""));
        return b;
    }

    private void setupCloseWindowEvent() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });
    }

    private void setupFrame(Component... components) {
        for (Component component : components) {
            add(component);
        }

        setSize(800, 800);
        setBackground(new Color(195, 195, 195));
        setLayout(null); //no layout manager
        setVisible(true);
        setTitle("Log Formatter");
    }
}
