import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleClassGUI {
    public JFrame frame;
    public JTextField field1;
    public JButton button1, button2;

    public SimpleClassGUI() {
        // Set up the frame
        frame = new JFrame("Simple Example");
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Need to create this before button ActionListener code
        field1 = new JTextField();
        button1 = new JButton("Clear");
        button2 = new JButton("Do Something");

        frame.add(button1);
        frame.add(button2);
        frame.add(field1);

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                field1.setText("");
            }
        });

        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                method1();
            }
        });

        // pack and show
        frame.pack();
        frame.setVisible(true);
    }

    // The code for this method cannot work
    // because we only have local variables
    public void method1() {
        field1.setText("Hi");
    }

    public static void main(String[] args) {
        SimpleClassGUI s = new SimpleClassGUI();
    }
}
