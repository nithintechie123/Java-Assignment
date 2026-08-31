// 5. Create a GUI in Java consisting of a single frame with three text fields num1,
// num2, and gcd1, three buttons labeled gcd, clear and exit. Now add the following
// functionality to the GUI:
// Enter an integer into the text field labeled num1 and another into the text field
// labeled num2. When the ged button is clicked, the gcd (greatest common
// divisor) of these two integers should appear in the text field labeled gcd1.
// When the clear button is clicked, it clears all three text fields to blanks. When
// the exit button is clicked, it closes the frame and terminates the application.


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class GCDGUI extends JFrame implements ActionListener{

    JLabel l1,l2,l3;
    JTextField num1,num2,gcd1;
    JButton gcd,clear,exit;
    
    public GCDGUI(){
        setLayout(new FlowLayout());

        l1=new JLabel("Num1");
        l2=new JLabel("Num2");
        l3=new JLabel("GCD");

        num1=new JTextField(20);
        num2=new JTextField(20);
        gcd1=new JTextField(20);

        gcd=new JButton("GCD");
        clear=new JButton("Clear");
        exit=new JButton("Exit");

       
        gcd.addActionListener(this);
        clear.addActionListener(this);
        exit.addActionListener(this);

        add(l1);
        add(num1);
        add(l2);
        add(num2);
        add(l3);
        add(gcd1);

        add(gcd);
        add(clear);
        add(exit);

        setTitle("GCD Calculator");
        setSize(280, 200);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==gcd){
            int a=Integer.parseInt(num1.getText());
            int b=Integer.parseInt(num2.getText());
            while(b!=0){
                int temp=b;
                b=a%b;
                a=temp;
            }
            gcd1.setText(String.valueOf(a));
        }else if(e.getSource()==clear){
            num1.setText("");
            num2.setText("");
            gcd1.setText("");
        }else if(e.getSource()==exit){
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new GCDGUI();
    }
}