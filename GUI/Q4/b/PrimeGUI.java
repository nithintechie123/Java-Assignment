
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PrimeGUI extends JFrame implements ActionListener{
    JLabel label;
    JTextField textField;
    JButton button;
    JTextArea result;
    
    public PrimeGUI(){
        setTitle("Prime Numbers");
        setSize(400,350);
        setLayout(new FlowLayout());

        label=new JLabel("Enter a Number:");
        textField=new JTextField(10);
        button=new JButton("Show Primes");
        result=new JTextArea(12,25);

        button.addActionListener(this);

        add(label);
        add(textField);
        add(button);
        add(new JScrollPane(result));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
       try {
            int n=Integer.parseInt(textField.getText());

        result.setText("Prime Numbers up to "+ n +":\n");

        for(int i=2;i<=n;i++){
            boolean isPrime=true;

            for(int j=2;j<=Math.sqrt(i);j++){
                if(i%j==0){
                    isPrime=false;
                    break;
                }
            }
            if(isPrime){
                result.append(i+"\n");
            }
        }
       } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,ex,"Number Format Exception",JOptionPane.ERROR_MESSAGE );
       }
    }

    public static void main(String[] args) {
        new PrimeGUI();
    }
}