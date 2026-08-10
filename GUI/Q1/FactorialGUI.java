// 1. Write a program in Java that receives an integer in one text field, and calculates
// its factorial value, when the button named "calculate" is clicked. The factorial
// value should appear in another text field. The first text field should be preceded
// by the label, "Enter the number", while the second text field should be preceded
// by the label, "Factorial value is ".

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FactorialGUI extends JFrame implements ActionListener {

    private JLabel l1, l2;
    private JTextField t1, t2;
    private JButton b;

    public FactorialGUI() {
        l1 = new JLabel("Enter the number");
        l2 = new JLabel("Factorial value is");

        t1 = new JTextField(20);
        t2 = new JTextField(20);
        t2.setEditable(false);

        b = new JButton("Calculate");
        b.addActionListener(this);

        // JPanel panel = new JPanel(new FlowLayout());
        // panel.add(l1);
        // panel.add(t1);
        // panel.add(l2);
        // panel.add(t2);
        // panel.add(b);

        // add(panel);
        setLayout(new FlowLayout());
        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(b);

        setTitle("Factorial Calculator");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int n = Integer.parseInt(t1.getText().trim());
            long fact = 1;

            for (int i = 1; i <= n; i++) {
                fact *= i;
            }

            t2.setText(String.valueOf(fact));
        } catch (NumberFormatException ex) {
            t2.setText("Invalid input");
        }
    }

    public static void main(String[] args) {
        new FactorialGUI();
    }
}