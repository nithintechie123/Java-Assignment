// 3. Write a Java program that creates a user interface to perform integer divisions.
// The user enters two numbers in the text fields, Num1 and Num2. The division of
// Num1 and Num2 is displayed in the Result field when the Divide button is
// clicked. If Num1 or Num2 were not an integer, the program would throw a
// Number Format Exception. If Num2 were Zero, the program would throw an
// Arithmetic Exception Display the exception in a message dialog box.

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class IntegerDivision extends JFrame implements ActionListener {

    private final JTextField num1Field;
    private final JTextField num2Field;
    private final JTextField resultField;

    public IntegerDivision() {
        setTitle("Integer Division");
        setSize(350, 180);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 10));

        num1Field = new JTextField();
        num2Field = new JTextField();
        resultField = new JTextField();
        resultField.setEditable(false);

        JButton divideButton = new JButton("Divide");
        divideButton.addActionListener(this);

        add(new JLabel("Num1:"));
        add(num1Field);
        add(new JLabel("Num2:"));
        add(num2Field);
        add(new JLabel("Result:"));
        add(resultField);
        add(new JLabel());
        add(divideButton);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            int num1 = Integer.parseInt(num1Field.getText());
            int num2 = Integer.parseInt(num2Field.getText());
            int result = num1 / num2;

            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, ex, "Number Format Exception", JOptionPane.ERROR_MESSAGE);
        } catch (ArithmeticException ex) {
            JOptionPane.showMessageDialog(this, ex, "Arithmetic Exception", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new IntegerDivision();
    }
}
