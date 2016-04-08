package sample;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Controller extends Frame {

    private final TextArea textArea;
    private final Button button;
    private final TextField textField;

    public Controller() {
        textArea = setupTextArea();
        button = setupPrintButton();
        textField = setupInputTextField();

        setupCloseWindowEvent();
        setupFrame(textArea, button, textField);
    }

    private TextField setupInputTextField() {
        TextField textField = new TextField(100);
        textField.setBounds(25, 50, 450, 25);
        return textField;
    }

    private TextArea setupTextArea() {
        TextArea textArea = new TextArea();
        textArea.setBounds(25, 150, 750, 600);
        return textArea;
    }

    private Button setupPrintButton() {
        Button b = new Button("Pretty print");
        b.setBounds(25, 100, 100, 25);
        b.addActionListener(e -> textArea.setText(new LogFormatter(textField.getText()).prettyPrint()));
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
    }
}
