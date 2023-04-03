import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TicTacToe implements ActionListener {

    JFrame frame;
    JTextField winner;
    JButton[] button = new JButton[9];
    JPanel panel;
    Font font = new Font("Monospaced", Font.BOLD, 30);
    int x = 0;

    TicTacToe() {

        frame = new JFrame("TicTacToe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450,440);
        frame.setLayout(null);

        winner = new JTextField();
        winner.setBounds(160,365,200,30);
        winner.setEditable(false);
        winner.setText("HELLO");
        winner.setFont(font);

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
        frame.add(winner);
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
        
        if((button[0].getText()+button[3].getText().concat(button[6].getText())).equals("XXX")
        || (button[0].getText()+button[3].getText().concat(button[6].getText())).equals("OOO")) {
            winner.setText(button[0].getText()+" WINS!");
        }
        if((button[1].getText()+button[4].getText().concat(button[7].getText())).equals("XXX")
        || (button[1].getText()+button[4].getText().concat(button[7].getText())).equals("OOO")) {
            winner.setText(button[1].getText()+" WINS!");
        }
        if((button[2].getText()+button[5].getText().concat(button[8].getText())).equals("XXX")
        || (button[2].getText()+button[5].getText().concat(button[8].getText())).equals("OOO")) {
            winner.setText(button[2].getText()+" WINS!");
        }
        if((button[0].getText()+button[1].getText().concat(button[2].getText())).equals("XXX")
        || (button[0].getText()+button[1].getText().concat(button[2].getText())).equals("OOO")) {
            winner.setText(button[0].getText()+" WINS!");
        }
        if((button[3].getText()+button[4].getText().concat(button[5].getText())).equals("XXX")
        || (button[3].getText()+button[4].getText().concat(button[5].getText())).equals("OOO")) {
            winner.setText(button[3].getText()+" WINS!");
        }
        if((button[6].getText()+button[7].getText().concat(button[8].getText())).equals("XXX")
        || (button[6].getText()+button[7].getText().concat(button[8].getText())).equals("OOO")) {
            winner.setText(button[6].getText()+" WINS!");
        }

        if((button[0].getText()+button[4].getText().concat(button[8].getText())).equals("XXX")
        || (button[0].getText()+button[4].getText().concat(button[8].getText())).equals("OOO")) {
            winner.setText(button[0].getText()+" WINS!");
        }
        if((button[6].getText()+button[4].getText().concat(button[2].getText())).equals("XXX")
        || (button[6].getText()+button[4].getText().concat(button[2].getText())).equals("OOO")) {
            winner.setText(button[6].getText()+" WINS!");
        }

        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }


    public static void main(String[] args){
        new TicTacToe();
        //
        //create a function that checks if there are straight x's or o's

    }
}