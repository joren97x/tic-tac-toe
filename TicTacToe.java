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
    int x = 0;

    TicTacToe() {

        frame = new JFrame("TicTacToe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450,440);
        frame.setLayout(null);

        for(int i = 0; i < button.length; i++) {
            button[i] = new JButton("");
            button[i].addActionListener(this);
            button[i].setFont(font);
        }

        panel = new JPanel();
        panel.setBounds(20,20,390,345);
        panel.setBackground(new Color(100,200,50));
        panel.setLayout(new GridLayout(3,3,2,2));
        
        for(int i = 0; i < 9; i++) {
            panel.add(button[i]);
        }


        frame.add(panel);
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
        for(int i = 0; i <= 8; i++) {
            if(x%2==0 && e.getSource() == button[i]){
                button[i].setText("X");
            }
            if(x%2!=0 && e.getSource() == button[i]){
                button[i].setText("O");
            }
        }
        this.x++;
        


        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }


    public static void main(String[] args){
        new TicTacToe();
        //
        //create a function that checks if there are straight x's or o's

    }
}