// 6. Write a Java program that handles mouse events using inner classes.

import java.awt.event.*;
import javax.swing.*;


public class MouseEventsDemo extends JFrame{
    JLabel label;

    public MouseEventsDemo(){
        label=new JLabel("Perform mouse actions...",JLabel.CENTER);
        add(label);

        //Register mouse listeners
        addMouseListener(new MyMouseListener());
        addMouseMotionListener(new MyMouseMotionListener());

        setTitle("Mouse Events Using Inner Classes");
        setSize(400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    //Inner class for MouseListener
    class MyMouseListener implements MouseListener{
        public void mouseClicked(MouseEvent e){
            label.setText("Mouse Clicked");
        }

        public void mousePressed(MouseEvent e){
            label.setText("Mouse Pressed");
        }

        public void mouseReleased(MouseEvent e){
            label.setText("Mouse Released");
        }

        public void mouseEntered(MouseEvent e){
            label.setText("Mouse Entered");
        }
        
        public void mouseExited(MouseEvent e){
            label.setText("Mouse Exited");
        }
    }

    //Inner class for MouseMotionListener
    class MyMouseMotionListener implements MouseMotionListener{
        
        public void mouseDragged(MouseEvent e){
            label.setText("Mouse Dragged: (" + e.getX() + ", " + e.getY() + ")");
        }

        public void mouseMoved(MouseEvent e) {
            label.setText("Mouse Moved: (" + e.getX() + ", " + e.getY() + ")");
        }
    }

    public static void main(String[] args) {
        new MouseEventsDemo();
    }
}
