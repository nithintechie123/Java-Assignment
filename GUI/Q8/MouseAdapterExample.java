
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;

// Write a Java program that handles mouse events using adapter classes.


public class MouseAdapterExample extends JFrame{
    JLabel label;

    public MouseAdapterExample(){
        label=new JLabel("Perform Mouse Actions");
        label.setBounds(120,100,250,30);

        add(label);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                label.setText("Mouse Clicked at (" + e.getX() + ","+e.getY()+")");
            }

            @Override
            public void mousePressed(MouseEvent e){
                label.setText("Mouse Pressed");
            }

            @Override
            public void mouseReleased(MouseEvent e){
                label.setText("Mouse Released");
            }

            @Override
            public void mouseEntered(MouseEvent e){
                label.setText("Mouse Entered");
            }
            @Override
            public void mouseExited(MouseEvent e){
                label.setText("Mouse Exited");
            }
        });

        setTitle("Mouse Adapter Example");
        setSize(450,300);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MouseAdapterExample();
    }
}
