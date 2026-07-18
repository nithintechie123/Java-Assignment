//  4. a)Write a Java program that simulates a traffic light. The program lets the user
// select one of three lights: red, yellow, or green. When a radio button is
// selected, the light is turned on, and only one light can be on at a time. No light
// is on when the program starts.


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;


public class TrafficLight extends JFrame implements ActionListener{

    JRadioButton red,yellow,green;

    public TrafficLight(){
        setTitle("Traffic Light Simulation");
        setSize(300,250);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        red=new JRadioButton("red");
        yellow=new JRadioButton("Yellow");
        green=new JRadioButton("Green");

        ButtonGroup bg=new ButtonGroup();
        bg.add(red);
        bg.add(yellow);
        bg.add(green);

        red.addActionListener(this);
        yellow.addActionListener(this);
        green.addActionListener(this);

        add(red);
        add(yellow);
        add(green);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(red.isSelected()){
            getContentPane().setBackground(Color.RED);
        }else if (yellow.isSelected()){
            getContentPane().setBackground(Color.YELLOW);
        }else{
            getContentPane().setBackground(Color.GREEN);
        }
    }

    public static void main(String[] args) {
        new TrafficLight();
    }
}