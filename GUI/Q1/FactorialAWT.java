// 1. Write a program in Java that receives an integer in one text field, and calculates
// its factorial value, when the button named "calculate" is clicked. The factorial
// value should appear in another text field. The first text field should be preceded
// by the label, "Enter the number", while the second text field should be preceded
// by the label, "Factorial value is ".

import java.awt.*;
import java.awt.event.*;

public class FactorialAWT extends Frame implements ActionListener {

    Label l1, l2;
    TextField t1, t2;
    Button b;

    FactorialAWT() {

        l1 = new Label("Enter the number");
        l2 = new Label("Factorial value is");

        t1 = new TextField(20);
        t2 = new TextField(20);

        b = new Button("Calculate");

        setLayout(new FlowLayout());

        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(b);

        b.addActionListener(this);

        setTitle("Factorial Calculator");
        setSize(350, 200);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent e) {

        int n = Integer.parseInt(t1.getText());
        long fact = 1;

        for (int i = 1; i <= n; i++) {
            fact = fact * i;
        }

        t2.setText(fact + "");
    }

    public static void main(String[] args) {
        new FactorialAWT();
    }
}