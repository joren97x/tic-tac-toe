import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TicTacToe implements ActionListener {

    JFrame frame;
    JTextField winner;
    JLabel scoreboard, Xscore, Oscore;
    JButton[] button = new JButton[9];
    JPanel panel;
    JButton[] menuButton = new JButton[2];
    JPanel menu;
    Font font = new Font("Monospaced", Font.BOLD, 30);
    int x = 0;

    TicTacToe() {

        frame = new JFrame("TicTacToe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450,550);
        frame.setLayout(null);

        scoreboard = new JLabel("scoreboard");
        scoreboard.setFont(font);
        scoreboard.setBounds(110, -80, 400, 200);

        Xscore = new JLabel("X: 0");
        Xscore.setFont(font);
        Xscore.setBounds(40, -35, 100, 200);

        Oscore = new JLabel("O: 0");
        Oscore.setFont(font);
        Oscore.setBounds(270, -35, 100, 200);

        winner = new JTextField();
        winner.setBounds(160,450,200,30);
        winner.setEditable(false);
        winner.setText("HELLO");
        winner.setFont(font);

        panel = new JPanel();
        panel.setBounds(20,100,390,345);
        panel.setBackground(new Color(100,200,50));
        panel.setLayout(new GridLayout(3,3,2,2));

        menu = new JPanel();
        menu.setBounds(100, 150, 220,200);
        menu.setBackground(new Color(34,34,34));
        menu.setLayout(new GridLayout(2,1,5,5));

        menuButton[0] = new JButton("Restart");
        menuButton[1] = new JButton("Quit");

        for(int i = 0; i < button.length; i++) {
            button[i] = new JButton("");
            button[i].addActionListener(this);
            button[i].setFont(font);
        }

        for(int i = 0; i < menuButton.length; i++) {
            menuButton[i].setFont(font);
            menuButton[i].addActionListener(this);
            menu.add(menuButton[i]);
        }

        for(int i = 0; i < 9; i++) {
            panel.add(button[i]);
        }

        menu.setVisible(false);
        frame.add(panel);
        frame.add(menu);
        frame.add(winner);
        frame.add(scoreboard);
        frame.add(Xscore);
        frame.add(Oscore);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
        for(int i = 0; i <= 8; i++) {
            if(x%2==0 && e.getSource() == button[i]){
                if(button[i].getText().equals("X") || button[i].getText().equals("O")) {
                    //do nothing
                }
                else {
                    button[i].setText("X");
                    this.x++;
                }
            }
            if(x%2!=0 && e.getSource() == button[i]){
                if(button[i].getText().equals("X") || button[i].getText().equals("O")) {
                    //do nothing
                }
                else {
                    button[i].setText("O");
                    this.x++;
                }
            }
        }

        if(e.getSource() == menuButton[1]){
            System.exit(0);
        }

        if(e.getSource() == menuButton[0]) {
            for(int i = 0; i < 9; i++) {
                button[i].setText("");
                menu.setVisible(false);
                panel.setVisible(true); 
                this.x = 0;               
            }
        }
        
        if((button[0].getText()+button[3].getText().concat(button[6].getText())).equals("XXX")
        || (button[0].getText()+button[3].getText().concat(button[6].getText())).equals("OOO")) {
            winner.setText(button[0].getText()+" WINS!");
            panel.setVisible(false);
            menu.setVisible(true);
            if(button[0].getText().equals("X")){
                int score = Character.getNumericValue(Xscore.getText().charAt(3));
                score++;
                Xscore.setText("X: "+Integer.toString(score));
            }
            else {
                int score = Character.getNumericValue(Oscore.getText().charAt(3));
                score++;
                Oscore.setText("O: "+Integer.toString(score));
            }
        }
        if((button[1].getText()+button[4].getText().concat(button[7].getText())).equals("XXX")
        || (button[1].getText()+button[4].getText().concat(button[7].getText())).equals("OOO")) {
            winner.setText(button[1].getText()+" WINS!");
            panel.setVisible(false);
            menu.setVisible(true);
            if(button[1].getText().equals("X")){
                int score = Character.getNumericValue(Xscore.getText().charAt(3));
                score++;
                Xscore.setText("X: "+Integer.toString(score));
            }
            else {
                int score = Character.getNumericValue(Oscore.getText().charAt(3));
                score++;
                Oscore.setText("O: "+Integer.toString(score));
            }
        }
        if((button[2].getText()+button[5].getText().concat(button[8].getText())).equals("XXX")
        || (button[2].getText()+button[5].getText().concat(button[8].getText())).equals("OOO")) {
            winner.setText(button[2].getText()+" WINS!");
            panel.setVisible(false);
            menu.setVisible(true);
            if(button[2].getText().equals("X")){
                int score = Character.getNumericValue(Xscore.getText().charAt(3));
                score++;
                Xscore.setText("X: "+Integer.toString(score));
            }
            else {
                int score = Character.getNumericValue(Oscore.getText().charAt(3));
                score++;
                Oscore.setText("O: "+Integer.toString(score));
            }
        }
        if((button[0].getText()+button[1].getText().concat(button[2].getText())).equals("XXX")
        || (button[0].getText()+button[1].getText().concat(button[2].getText())).equals("OOO")) {
            winner.setText(button[0].getText()+" WINS!");
            panel.setVisible(false);
            menu.setVisible(true);
            if(button[0].getText().equals("X")){
                int score = Character.getNumericValue(Xscore.getText().charAt(3));
                score++;
                Xscore.setText("X: "+Integer.toString(score));
            }
            else {
                int score = Character.getNumericValue(Oscore.getText().charAt(3));
                score++;
                Oscore.setText("O: "+Integer.toString(score));
            }
        }
        if((button[3].getText()+button[4].getText().concat(button[5].getText())).equals("XXX")
        || (button[3].getText()+button[4].getText().concat(button[5].getText())).equals("OOO")) {
            winner.setText(button[3].getText()+" WINS!");
            panel.setVisible(false);
            menu.setVisible(true);
            if(button[3].getText().equals("X")){
                int score = Character.getNumericValue(Xscore.getText().charAt(3));
                score++;
                Xscore.setText("X: "+Integer.toString(score));
            }
            else {
                int score = Character.getNumericValue(Oscore.getText().charAt(3));
                score++;
                Oscore.setText("O: "+Integer.toString(score));
            }
        }
        if((button[6].getText()+button[7].getText().concat(button[8].getText())).equals("XXX")
        || (button[6].getText()+button[7].getText().concat(button[8].getText())).equals("OOO")) {
            winner.setText(button[6].getText()+" WINS!");
            panel.setVisible(false);
            menu.setVisible(true);
            if(button[6].getText().equals("X")){
                int score = Character.getNumericValue(Xscore.getText().charAt(3));
                score++;
                Xscore.setText("X: "+Integer.toString(score));
            }
            else {
                int score = Character.getNumericValue(Oscore.getText().charAt(3));
                score++;
                Oscore.setText("O: "+Integer.toString(score));
            }
        }
        if((button[0].getText()+button[4].getText().concat(button[8].getText())).equals("XXX")
        || (button[0].getText()+button[4].getText().concat(button[8].getText())).equals("OOO")) {
            winner.setText(button[0].getText()+" WINS!");
            panel.setVisible(false);
            menu.setVisible(true);
            if(button[0].getText().equals("X")){
                int score = Character.getNumericValue(Xscore.getText().charAt(3));
                score++;
                Xscore.setText("X: "+Integer.toString(score));
            }
            else {
                int score = Character.getNumericValue(Oscore.getText().charAt(3));
                score++;
                Oscore.setText("O: "+Integer.toString(score));
            }
        }
        if((button[6].getText()+button[4].getText().concat(button[2].getText())).equals("XXX")
        || (button[6].getText()+button[4].getText().concat(button[2].getText())).equals("OOO")) {
            winner.setText(button[6].getText()+" WINS!");
            panel.setVisible(false);
            menu.setVisible(true);
            if(button[6].getText().equals("X")){
                int score = Character.getNumericValue(Xscore.getText().charAt(3));
                score++;
                Xscore.setText("X: "+Integer.toString(score));
            }
            else {
                int score = Character.getNumericValue(Oscore.getText().charAt(3));
                score++;
                Oscore.setText("O: "+Integer.toString(score));
            }
        }

        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }


    public static void main(String[] args){
        new TicTacToe();
        //
        //create a function that checks if there are straight x's or o's == DONE!
        //add menu functionalities == done
        //fix scoreboard == DONE
        //add AI enemy

    }
}