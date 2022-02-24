import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

    // Swing instance variables
    JFrame frame;
    JTextField field1;
    JPanel panel1, panel2, panel3, panel4,panel5;
    JButton button1, button2, button3, button4, button5,
            button6, button7, button8, button9, button0,
            buttonDivide, buttonTimes, buttonMinus, buttonPlus,
            buttonClear, buttonEquals, buttonPower,buttonFactorial,buttonAnswer,buttonModulo;

    // Instance variables that will be used for our math
    String op;
    String preans = "1";
    int arg1;
    private long factorialUsingRecursion(int n) {
        if (n <= 2) {
            return n;
        }
        return n * factorialUsingRecursion(n - 1);
    }
    private double calcstring(String str) {
        System.out.println(str);
        str = str.replaceAll("ans",preans);
        System.out.println(str);
        if (str.indexOf('+') == -1 && str.indexOf('-') == -1 && str.indexOf('*') == -1 && str.indexOf('/') == -1 && str.indexOf('%') == -1 && str.indexOf('^') == -1 && str.indexOf('!') == -1) {
            return Double.parseDouble(str);
        } else if (str.indexOf('+') == -1 && str.indexOf('-') == -1 && str.indexOf('*') == -1 && str.indexOf('/') == -1 && str.indexOf('%') == -1 && str.indexOf('^') == -1) {
            int num = Integer.parseInt(str.substring(0,str.length()-1));
            return factorialUsingRecursion(num);
        }
            else
        {
            if (str.indexOf("!") != -1) {
                return calcstring(str.substring(0,1+str.indexOf("!")))*calcstring(str.substring(1+str.indexOf("!")));
            } else
            if (str.indexOf("^") != -1) {
                return Math.pow(calcstring(str.substring(0,str.indexOf("^"))),calcstring(str.substring(1+str.indexOf("^"))));
            } else
            if (str.indexOf("/") != -1 && str.indexOf("*") != -1 && str.indexOf("%") != -1) {
                int lower = str.indexOf("/");
                if (lower < str.indexOf("*") && lower < str.indexOf("%")) {
                    return calcstring(str.substring(0,lower))/calcstring(str.substring(1+lower));
                    //return calcstring(str.substring(0,str.indexOf("*")))*calcstring(str.substring(1+str.indexOf("*")));
                } else if ((lower < str.indexOf("*") && lower > str.indexOf("%"))) {
                    return calcstring(str.substring(0,str.indexOf("%")))%calcstring(str.substring(1+str.indexOf("%")));
                } else if ((lower > str.indexOf("*") && lower < str.indexOf("%"))) {
                    return calcstring(str.substring(0,str.indexOf("*")))*calcstring(str.substring(1+str.indexOf("*")));
                }

                } else
            if (str.indexOf("/") != -1 && str.indexOf("*") != -1) {
                int lower = str.indexOf("/");
                if (lower > str.indexOf("*")) {
                    return calcstring(str.substring(0,str.indexOf("*")))*calcstring(str.substring(1+str.indexOf("*")));
                } else {
                    return calcstring(str.substring(0,lower))/calcstring(str.substring(1+lower));
                }
            }  else
            if (str.indexOf("/") != -1 && str.indexOf("%") != -1) {
                int lower = str.indexOf("/");
                if (lower > str.indexOf("%")) {
                    return calcstring(str.substring(0,str.indexOf("%")))%calcstring(str.substring(1+str.indexOf("%")));
                } else {
                    return calcstring(str.substring(0,lower))/calcstring(str.substring(1+lower));
                }
            } else
            if (str.indexOf("*") != -1 && str.indexOf("%") != -1) {
                int lower = str.indexOf("*");
                if (lower > str.indexOf("*")) {
                    return calcstring(str.substring(0,str.indexOf("%")))%calcstring(str.substring(1+str.indexOf("%")));
                } else {
                    return calcstring(str.substring(0,lower))*calcstring(str.substring(1+lower));
                }
            }  else if (str.indexOf("*") != -1) {
                return calcstring(str.substring(0,str.indexOf("*")))*calcstring(str.substring(1+str.indexOf("*")));
            } else if (str.indexOf("/") != -1) {
                return calcstring(str.substring(0,str.indexOf("/")))/calcstring(str.substring(1+str.indexOf("/")));
            }  else if (str.indexOf("%") != -1) {
                return calcstring(str.substring(0,str.indexOf("%")))%calcstring(str.substring(1+str.indexOf("%")));
            } else if (str.indexOf("-") != -1 && str.indexOf("+") != -1) {
                int lower = str.indexOf("-");
                if (lower > str.indexOf("+")) {
                    return calcstring(str.substring(0,str.indexOf("+")))+calcstring(str.substring(1+str.indexOf("+")));
                } else {
                    return calcstring(str.substring(0,lower))-calcstring(str.substring(1+lower));
                }
            } else if (str.indexOf("-") != -1) {
                return calcstring(str.substring(0,str.indexOf("-")))-calcstring(str.substring(1+str.indexOf("-")));
            } else if (str.indexOf("+") != -1) {
                return calcstring(str.substring(0,str.indexOf("+")))+calcstring(str.substring(1+str.indexOf("+")));
            }
            return 0;
        }
    }
    public Calculator() {
        // 1. Create the frame (the window that will pop up)
        frame = new JFrame("Calculator");
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        // 2. Choose what happens when you click the exit button
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 3. Create components and put them in the frame
        field1 = new JTextField(15);
        field1.setHorizontalAlignment(SwingConstants.RIGHT);

        panel1 = new JPanel();
        button7 = new JButton("7");
        panel1.add(button7);
        button8 = new JButton("8");
        panel1.add(button8);
        button9 = new JButton("9");
        panel1.add(button9);
        buttonDivide = new JButton("/");
        panel1.add(buttonDivide);

        panel2 = new JPanel();
        button4 = new JButton("4");
        panel2.add(button4);
        button5 = new JButton("5");
        panel2.add(button5);
        button6 = new JButton("6");
        panel2.add(button6);
        buttonTimes = new JButton("*");
        panel2.add(buttonTimes);

        panel3 = new JPanel();
        button1 = new JButton("1");
        panel3.add(button1);
        button2 = new JButton("2");
        panel3.add(button2);
        button3 = new JButton("3");
        panel3.add(button3);
        buttonMinus = new JButton("-");
        panel3.add(buttonMinus);

        panel4 = new JPanel();
        button0 = new JButton("0");
        panel4.add(button0);
        buttonClear = new JButton("AC");
        panel4.add(buttonClear);
        buttonEquals = new JButton("=");
        panel4.add(buttonEquals);
        buttonPlus = new JButton("+");
        panel4.add(buttonPlus);

        panel5 = new JPanel();
        buttonPower = new JButton("^");
        panel5.add(buttonPower);
        buttonFactorial = new JButton("!");
        panel5.add(buttonFactorial);
        buttonAnswer = new JButton("ans");
        panel5.add(buttonAnswer);
        buttonModulo = new JButton("%");
        panel5.add(buttonModulo);

        // Add implemented actionListener method to each button
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);
        button7.addActionListener(this);
        button8.addActionListener(this);
        button9.addActionListener(this);
        button0.addActionListener(this);
        buttonPlus.addActionListener(this);
        buttonMinus.addActionListener(this);
        buttonDivide.addActionListener(this);
        buttonTimes.addActionListener(this);
        buttonEquals.addActionListener(this);
        buttonFactorial.addActionListener(this);
        buttonAnswer.addActionListener(this);
        buttonModulo.addActionListener(this);
        buttonPower.addActionListener(this);
        buttonClear.addActionListener(this);
        // ...
        // ...
        // YOUR CODE HERE

        // Add panels and everything to the actual frame
        frame.add(field1);
        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);
        frame.add(panel4);
        frame.add(panel5);

        // 4. Size the frame
        frame.pack();

        // 5. Show the frame
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String buttonName = ae.getActionCommand();

        if (buttonName.equals("1")) {
            field1.setText(field1.getText() + "1");
        }else
        if (buttonName.equals("AC")) {
            field1.setText("");
        }
        else if (buttonName.equals("2")) {
            field1.setText(field1.getText() + "2");
        }
        else if (buttonName.equals("3")) {
            field1.setText(field1.getText() + "3");
        }
        else if (buttonName.equals("4")) {
            field1.setText(field1.getText() + "4");
        }
        else if (buttonName.equals("5")) {
            field1.setText(field1.getText() + "5");
        }
        else if (buttonName.equals("6")) {
            field1.setText(field1.getText() + "6");
        }
        else if (buttonName.equals("7")) {
            field1.setText(field1.getText() + "7");
        }
        else if (buttonName.equals("8")) {
            field1.setText(field1.getText() + "8");
        }
        else if (buttonName.equals("9")) {
            field1.setText(field1.getText() + "9");
        }
        else if (buttonName.equals("0")) {
            field1.setText(field1.getText() + "0");
        }
        else if (buttonName.equals("-")) {
            field1.setText(field1.getText() + "-");
        }
        else if (buttonName.equals("+")) {
            field1.setText(field1.getText() + "+");
        }
        else if (buttonName.equals("=")) {
            preans = ""+calcstring(field1.getText());
            field1.setText(""+calcstring(field1.getText()));
        }
        else if (buttonName.equals("*")) {
            field1.setText(field1.getText() + "*");
        }
        else if (buttonName.equals("/")) {
            field1.setText(field1.getText() + "/");
        }
        else if (buttonName.equals("!")) {
            field1.setText(field1.getText() + "!");
        }
        else if (buttonName.equals("%")) {
            field1.setText(field1.getText() + "%");
        }
        else if (buttonName.equals("ans")) {
            field1.setText(field1.getText() + "ans");
        }
        else if (buttonName.equals("^")) {
            field1.setText(field1.getText() + "^");
        }


    }

    public static void main(String[] args) {
        Calculator c = new Calculator();
    }
}
