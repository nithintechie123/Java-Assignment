// 5. Create a GUI in Java consisting of a single frame with three text fields num1,
// num2, and ged1, three buttons labeled gcd, clear and exit. Now add the following
// functionality to the GUI:
// Enter an integer into the text field labeled num1 and another into the text field
// labeled num2. When the ged button is clicked, the gcd (greatest common
// divisor) of these two integers should appear in the text field labeled ged1.
// When the clear button is clicked, it clears all three text fields to blanks. When
// the exit button is clicked, it closes the frame and terminates the application.
// 6. Write a Java program that handles mouse events using inner classes.


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class GCDGUI extends JFrame implements ActionListener{

    JLabel l1,l2,l3;
    JTextField num1,num2,resGcd;
    JButton gcd,clear,exit;
    
    public GCDGUI(){
        setLayout(null);

        l1=new JLabel("Num1");
        l2=new JLabel("Num2");
        l3=new JLabel("GCD");

        num1=new JTextField();
        num2=new JTextField();
        resGcd=new JTextField();

        gcd=new JButton("GCD");
        clear=new JButton("Clear");
        exit=new JButton("Exit");

        l1.setBounds(30,30,80,30);
        num1.setBounds(120,30,120,30);

        l2.setBounds(30,80,80,30);
        num2.setBounds(120,80,120,30);

        l3.setBounds(30,130,80,30);
        resGcd.setBounds(120,130,120,30);

        gcd.setBounds(20,190,80,30);
        clear.setBounds(110,190,80,30);
        exit.setBounds(200,190,80,30);

        gcd.addActionListener(this);
        clear.addActionListener(this);
        exit.addActionListener(this);

        add(l1);
        add(l2);
        add(l3);

        add(num1);
        add(num2);
        add(resGcd);

        add(gcd);
        add(clear);
        add(exit);

        setTitle("GCD Calculator");
        setSize(320, 260);
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
            resGcd.setText(String.valueOf(a));
        }else if(e.getSource()==clear){
            num1.setText("");
            num2.setText("");
            resGcd.setText("");
        }else if(e.getSource()==exit){
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new GCDGUI();
    }
}