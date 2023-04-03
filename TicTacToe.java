import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TicTacToe implements ActionListener {

    JFrame frame;
    JButton[] button = new JButton[9];
    JPanel panel;
    Font font = new Font("Monospaced", Font.BOLD, 30);

    TicTacToe() {

        frame = new JFrame("TicTacToe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450,440);
        frame.setVisible(true);
        frame.setBackground(new Color(35,35,35));

        for(int i = 0; i < button.length; i++) {
            button[i] = new JButton(String.valueOf(i));
            button[i].addActionListener(this);
            button[i].setFont(font);
        }

        panel = new JPanel();
        panel.setBounds(20,20,390,345);
        panel.setBackground(new Color(5,6,7));
        panel.setLayout(new GridLayout(3,3,2,2));
        
        panel.add(button[0]);
        panel.add(button[1]);
        panel.add(button[2]);
        panel.add(button[3]);
        panel.add(button[4]);
        panel.add(button[5]);
        panel.add(button[6]);
        panel.add(button[7]);
        panel.add(button[8]);

        frame.add(panel);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }


    public static void main(String[] args){
        System.out.println("Hello");
        new TicTacToe();
    }
}
