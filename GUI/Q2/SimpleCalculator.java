// Write a Java program that works as a simple calculator. Use a grid layout to
// arrange buttons for the digits and for the +, -,*, % operations. Add a text field to
// display the result.
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener {

    JTextField display;
    JButton[] buttons;
    String[] keys = {
        "7", "8", "9", "+",
        "4", "5", "6", "-",
        "1", "2", "3", "*",
        "0", "%", "=", "Clear"
    };

    double num1, num2;
    char operator;

    Calculator() {

        display = new JTextField();
        display.setEditable(false);

        buttons = new JButton[keys.length];

        setLayout(new GridLayout(5, 1, 5, 5));

        add(display);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 5, 5));

        for (int i = 0; i < keys.length; i++) {
            buttons[i] = new JButton(keys[i]);
            buttons[i].addActionListener(this);
            panel.add(buttons[i]);
        }

        add(panel);

        setTitle("Simple Calculator");
        setSize(350, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        String s = e.getActionCommand();

        if (s.equals("Clear")) {
            display.setText("");

        } else if (s.equals("=")) {

            num2 = Double.parseDouble(display.getText());

            switch (operator) {
                case '+':
                    display.setText(String.valueOf(num1 + num2));
                    break;

                case '-':
                    display.setText(String.valueOf(num1 - num2));
                    break;

                case '*':
                    display.setText(String.valueOf(num1 * num2));
                    break;

                case '%':
                    display.setText(String.valueOf(num1 % num2));
                    break;
            }

        } else if (s.equals("+") || s.equals("-") ||
                   s.equals("*") || s.equals("%")) {

            num1 = Double.parseDouble(display.getText());
            operator = s.charAt(0);
            display.setText("");

        } else {
            display.setText(display.getText() + s);
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}