// 7. Write a Java program that handles keyboard events using inner classes.

import java.awt.event.*;
import javax.swing.*;

public class KeyboardEventsDemo extends JFrame {
    JLabel label;

    public KeyboardEventsDemo(){
        label=new JLabel("Press any key...",JLabel.CENTER);
        add(label);
        
        //Register keyboard listener
        addKeyListener(new MyKeyListener());

        setTitle("Keyboard Events Using Inner Classes");
        setSize(400,300);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setFocusable(true);
        setVisible(true);
    }

    class MyKeyListener implements KeyListener{
        
        public void keyPressed(KeyEvent e){
            label.setText("Key Pressed: "+ e.getKeyChar());
        }

        public void keyReleased(KeyEvent e){
            label.setText("Key Released : "+ e.getKeyChar());
        }

        public void keyTyped(KeyEvent e){
            label.setText("Key Typed: " + e.getKeyChar());
    }
    }

    public static void main(String[] args) {
        new KeyboardEventsDemo();
    }
}
