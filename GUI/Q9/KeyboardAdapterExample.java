
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;

// Write a Java program that handles keyboard events using adapter classes.

public class KeyboardAdapterExample extends JFrame {
    
    JLabel label;

    KeyboardAdapterExample(){
        label=new JLabel("Press any key....");
        label.setBounds(100,100,300,30);
        
        add(label);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                label.setText("Key Pressed: " + e.getKeyChar());
            }

            @Override
            public void keyReleased(KeyEvent e){
                label.setText("Key Released: " + e.getKeyChar());
            }

            @Override
            public void keyTyped(KeyEvent e){
                label.setText("Key Typed: " + e.getKeyChar());
            }
        });

        setTitle("Keyboard Adapter Example");
        setSize(450,300);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setFocusable(true);
        requestFocusInWindow();
    }

    public static void main(String[] args) {
        new KeyboardAdapterExample();
    }
}
