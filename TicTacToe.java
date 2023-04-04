import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.Random;

public class TicTacToe implements ActionListener {

    JFrame frame;
    Clip clip;
    JLabel scoreboard, Xscore, Oscore, announcer, selectEnemyLabel, selectInputLabel;
    JButton[] button = new JButton[9];
    JPanel panel, menu, startingEnemy, startingInput;
    JButton[] menuButton = new JButton[2];
    Random rand;
    JButton[] selectEnemyButton = new JButton[2];
    JButton[] selectInputButton = new JButton[2];
    Font font = new Font("Monospaced", Font.BOLD, 30);
    int x = 0; //this is to check if this num is even then the input should be X else O
    int enemy = 0; // to check if enemy is human or ai, 0 for human ; 1 for ai
    String userInput = null;

    TicTacToe() {

        frame = new JFrame("Tic Tac Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450,550);
        frame.setLayout(null);

        Image logo = Toolkit.getDefaultToolkit().getImage("logo.png");
        frame.setIconImage(logo);

        rand = new Random();

        scoreboard = new JLabel("scoreboard");
        scoreboard.setFont(font);
        scoreboard.setBounds(110, -80, 400, 200);

        Xscore = new JLabel("X: 0");
        Xscore.setFont(font);
        Xscore.setBounds(40, -35, 100, 200);

        Oscore = new JLabel("O: 0");
        Oscore.setFont(font);
        Oscore.setBounds(270, -35, 100, 200);

        announcer = new JLabel();
        announcer.setBounds(160,450,200,30);
        announcer.setText("X's turn");
        announcer.setFont(font);

        selectEnemyLabel = new JLabel();
        selectEnemyLabel.setBounds(50, 30, 400, 200);
        selectEnemyLabel.setText("Select your enemy");
        selectEnemyLabel.setFont(font);
        selectEnemyLabel.setBackground(new Color(10,15,20));

        selectInputLabel = new JLabel();
        selectInputLabel.setBounds(50, 30, 400, 200);
        selectInputLabel.setText("Select your Input");
        selectInputLabel.setFont(font);
        selectInputLabel.setBackground(new Color(10,15,20));

        startingEnemy = new JPanel();
        startingEnemy.setBounds(75, 175, 262, 200);
        startingEnemy.setBackground(new Color(34,54,65));
        startingEnemy.setLayout(new GridLayout(2,1,3,3));

        startingInput = new JPanel();
        startingInput.setBounds(75, 175, 262, 200);
        startingInput.setBackground(new Color(34,54,65));
        startingInput.setLayout(new GridLayout(2,1,3,3));

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

        selectEnemyButton[0] = new JButton("Human");
        selectEnemyButton[1] = new JButton("AI/bot");

        selectInputButton[0] = new JButton("X");
        selectInputButton[1] = new JButton("O");

        for(int i = 0; i < selectInputButton.length; i++) {
            selectInputButton[i].setFont(font);
            selectInputButton[i].addActionListener(this);
            startingInput.add(selectInputButton[i]);           
        }

        for(int i = 0; i < button.length; i++) {
            button[i] = new JButton("");
            button[i].addActionListener(this);
            button[i].setFont(font);
        }

        for(int i = 0; i < selectEnemyButton.length; i++) {
            selectEnemyButton[i].setFont(font);
            selectEnemyButton[i].addActionListener(this);
            startingEnemy.add(selectEnemyButton[i]);
        }

        for(int i = 0; i < menuButton.length; i++) {
            menuButton[i].setFont(font);
            menuButton[i].addActionListener(this);
            menu.add(menuButton[i]);
        }

        for(int i = 0; i < 9; i++) {
            panel.add(button[i]);
        }

        panel.setVisible(false);
        menu.setVisible(false);
        scoreboard.setVisible(false);
        announcer.setVisible(false);
        Xscore.setVisible(false);
        Oscore.setVisible(false);
        startingInput.setVisible(false);
        selectInputLabel.setVisible(false);

        frame.add(panel);
        frame.add(menu);
        frame.add(startingInput);
        frame.add(selectEnemyLabel);
        frame.add(selectInputLabel);
        frame.add(startingEnemy);
        frame.add(announcer);
        frame.add(scoreboard);
        frame.add(Xscore);
        frame.add(Oscore);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        selectMenu(e);
        checkEnemy(e);
        if(enemy ==0){
            checkWinner();
        }

        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
    public void playSound(String filename) {
        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File(filename));
            clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
        }
    }
    public void selectMenu(ActionEvent e) {
        
        if(e.getSource() == menuButton[0]) {
            for(int i = 0; i < 9; i++) {
                button[i].setText("");
            }
            playSound("click.wav");
            menu.setVisible(false);
            panel.setVisible(true); 
            announcer.setText("X's turn");
        }

        if(e.getSource() == menuButton[1]){
            System.exit(0);
        }

        if(e.getSource() == selectEnemyButton[0]){
            playSound("click.wav");
            enemy = 0;
            startingEnemy.setVisible(false);
            selectEnemyLabel.setVisible(false);
            selectInputLabel.setVisible(true);
            startingInput.setVisible(true);
        }

        if(e.getSource() == selectEnemyButton[1]){
            playSound("click.wav");
            enemy = 1;
            startingEnemy.setVisible(false);
            selectEnemyLabel.setVisible(false);
            selectInputLabel.setVisible(true);
            startingInput.setVisible(true);
        }

        if(e.getSource() == selectInputButton[0]){
            playSound("click.wav");
            panel.setVisible(true);
            scoreboard.setVisible(true);
            announcer.setVisible(true);
            Oscore.setVisible(true);
            Xscore.setVisible(true);
            startingEnemy.setVisible(false);
            selectEnemyLabel.setVisible(false);
            startingInput.setVisible(false);
            selectEnemyLabel.setVisible(false);
            selectInputLabel.setVisible(false);
            this.userInput = "X";
        }

        if(e.getSource() == selectInputButton[1]){
            playSound("click.wav");
            this.x += 1;
            announcer.setText("O's turn");
            panel.setVisible(true);
            scoreboard.setVisible(true);
            announcer.setVisible(true);
            Oscore.setVisible(true);
            Xscore.setVisible(true);
            startingEnemy.setVisible(false);
            selectEnemyLabel.setVisible(false);
            startingInput.setVisible(false);
            selectEnemyLabel.setVisible(false);
            selectInputLabel.setVisible(false);
            this.userInput = "O";
        }

    }
    public void checkEnemy(ActionEvent e) {

        if(enemy == 0) {
            for(int i = 0; i <= 8; i++) {
                if(x%2==0 && e.getSource() == button[i]){
                    if(button[i].getText().equals("X") || button[i].getText().equals("O")) {
                        //do nothing
                    }
                    else {
                        button[i].setText("X");
                        playSound("click.wav");
                        this.x++;
                        announcer.setText("O's turn");
                    }
                }
                if(x%2!=0 && e.getSource() == button[i]){
                    if(button[i].getText().equals("X") || button[i].getText().equals("O")) {
                        //do nothing
                    }
                    else {
                        button[i].setText("O");
                        playSound("click.wav");
                        this.x++;
                        announcer.setText("X's turn");
                    }
                }
            }
        }
        //IF ENEMY IS AI
        if(enemy == 1) {
            for(int i = 0; i <= 8; i++) {
                if(x%2==0 && e.getSource() == button[i]){
                    if(button[i].getText().equals("X") || button[i].getText().equals("O")) {
                        //do nothing
                    }
                    else {
                        button[i].setText("X");
                        playSound("click.wav");
                        this.x++;
                        announcer.setText("X's turn");
                        //AI STUFFS
                        checkWinner();
                        if(this.x >= 9){
                            break;
                        }
                        else if(x==0){
                            break;
                        }
                        else if(x==1 && userInput == "O"){
                            break;
                        }
                        int copyX = this.x;
                        while(copyX == this.x) {
                            int randNum = rand.nextInt(9);
                            if(button[randNum].getText().equals("X") || button[randNum].getText().equals("O")) {
                                //do nothing
                            }
                            else {
                                button[randNum].setText("O");
                                this.x++;
                                checkWinner();
                            }
                        }
                    }
                }
                if(x%2!=0 && e.getSource() == button[i]){
                    if(button[i].getText().equals("X") || button[i].getText().equals("O")) {
                        //do nothing
                    }
                    else {
                        button[i].setText("O");
                        playSound("click.wav");
                        this.x++;
                        announcer.setText("O's turn");
                        //AI STUFFS
                        checkWinner();
                        if(this.x >= 9){
                            break;
                        }
                        else if(x==0){
                            break;
                        }
                        else if(x==1 && userInput == "O"){
                            break;
                        }
                        int copyX = this.x;
                        while(copyX == this.x) {
                            int randNum = rand.nextInt(9);
                            if(button[randNum].getText().equals("X") || button[randNum].getText().equals("O")) {
                                //do nothing
                            }
                            else {
                                button[randNum].setText("X");
                                this.x++;
                                checkWinner();
                            }
                        }
                    }
                }
            }
        }
    }
    public void checkWinner() {

        if((button[0].getText()+button[3].getText().concat(button[6].getText())).equals("XXX")
        || (button[0].getText()+button[3].getText().concat(button[6].getText())).equals("OOO")) {
            playSound("winner.wav");
            announcer.setText(button[0].getText()+" WINS!");
            panel.setVisible(false);
            menu.setVisible(true);
            this.x = (userInput == "X" ? 0 : 1);
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
            playSound("winner.wav");
            announcer.setText(button[1].getText()+" WINS!");
            panel.setVisible(false);
            menu.setVisible(true);
            this.x = (userInput == "X" ? 0 : 1);
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
            playSound("winner.wav");
            announcer.setText(button[2].getText()+" WINS!");
            panel.setVisible(false);
            menu.setVisible(true);
            this.x = (userInput == "X" ? 0 : 1);
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
            playSound("winner.wav");
            announcer.setText(button[0].getText()+" WINS!");
            panel.setVisible(false);
            menu.setVisible(true);
            this.x = (userInput == "X" ? 0 : 1);
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
            playSound("winner.wav");
            announcer.setText(button[3].getText()+" WINS!");
            panel.setVisible(false);
            menu.setVisible(true);
            this.x = (userInput == "X" ? 0 : 1);
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
            playSound("winner.wav");
            announcer.setText(button[6].getText()+" WINS!");
            panel.setVisible(false);
            menu.setVisible(true);
            this.x = (userInput == "X" ? 0 : 1);
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
            playSound("winner.wav");
            announcer.setText(button[0].getText()+" WINS!");
            panel.setVisible(false);
            menu.setVisible(true);
            this.x = (userInput == "X" ? 0 : 1);
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
            playSound("winner.wav");
            announcer.setText(button[6].getText()+" WINS!");
            panel.setVisible(false);
            menu.setVisible(true);
            this.x = (userInput == "X" ? 0 : 1);
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

        if(this.x == 9){
            playSound("winner.wav");
            announcer.setText("DRAW!");
            panel.setVisible(false);
            menu.setVisible(true);
            this.x = (userInput == "X" ? 0 : 1);
        }
    }
    public static void main(String[] args){
        new TicTacToe();
        //create a function that checks if there are straight x's or o's == DONE!
        //add menu functionalities == DONE NA OI KASAYOn
        //fix scoreboard == DONE
        //add AI enemy == kinda hard but still got it done :DDDDDDDDDD
        //style UI and add logo 

    }
}