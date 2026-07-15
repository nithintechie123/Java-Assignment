// Write a Java program that works as a simple calculator. Use a grid layout to
// arrange buttons for the digits and for the +, -,*, % operations. Add a text field to
// display the result.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SimpleCalculator extends JFrame implements ActionListener {

    JTextField textField;
    String operator = "";
    double num1 = 0, num2 = 0, result = 0;

    public SimpleCalculator() {
        setTitle("Simple Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Text Field
        textField = new JTextField();
        textField.setFont(new Font("Arial", Font.BOLD, 20));
        textField.setHorizontalAlignment(JTextField.RIGHT);
        add(textField, BorderLayout.NORTH);

        // Panel for buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 5, 5));

        // Buttons
        String[] buttons = {
            "7", "8", "9", "+",
            "4", "5", "6", "-",
            "1", "2", "3", "*",
            "0", "%", "=", "C"
        };

        for (String text : buttons) {
            JButton btn = new JButton(text);
            btn.setFont(new Font("Arial", Font.BOLD, 16));
            btn.addActionListener(this);
            panel.add(btn);
        }

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        // Digits
        if (command.matches("[0-9]")) {
            textField.setText(textField.getText() + command);
        } // Operators
        else if (command.matches("[+\\-*%]")) {
            String text = textField.getText();

            // Prevent multiple operators
            if (!text.endsWith("+") && !text.endsWith("-")
                    && !text.endsWith("*") && !text.endsWith("%")) {
                textField.setText(text + command);
            }
        } // Equals
        else if (command.equals("=")) {

            String exp = textField.getText();

            char op = ' ';
            if (exp.contains("+")) {
                op = '+'; 
            }else if (exp.contains("-")) {
                op = '-'; 
            }else if (exp.contains("*")) {
                op = '*'; 
            }else if (exp.contains("%")) {
                op = '%';
            }

            if (op != ' ') {
                String[] parts = exp.split("\\" + op);

                double num1 = Double.parseDouble(parts[0]);
                double num2 = Double.parseDouble(parts[1]);
                double result = 0;

                switch (op) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '%':
                        result = num1 % num2;
                        break;
                }

                textField.setText(String.valueOf(result));
            }
        } // Clear
        else if (command.equals("C")) {
            textField.setText("");
        }
    }

    public static void main(String[] args) {
        new SimpleCalculator();
    }
}
