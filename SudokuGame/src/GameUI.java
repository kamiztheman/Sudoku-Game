import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameUI {
    GameLogic gamelogic = new GameLogic();
    public static JTextField[][] txtbox = new JTextField[9][9];

        //creation of main game frame
        public void createMain(){

        //main game frame
        JFrame mainFrame = new JFrame("SudokuGame");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(600,700);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setResizable(false);
        mainFrame.setLayout(new BorderLayout());

        //panels to contain sudoku grid and buttons
        JPanel gridpanel = new JPanel();
        JPanel buttonpanel = new JPanel();
        gridpanel.setSize(mainFrame.getWidth(),400);
        gridpanel.setLayout(new GridLayout(9,9));
        buttonpanel.setLayout(new GridLayout(1,3));

        //textboxes for containing each int in puzzle
        for(int r = 0; r < 9;r++) {
            for(int c = 0; c <9;c++){
                txtbox[r][c] = new JTextField();
                txtbox[r][c].setBorder(BorderFactory.createLineBorder(Color.black));
                txtbox[r][c].setFont(new Font ("Arial", Font.PLAIN, 28));
                txtbox[r][c].setHorizontalAlignment(JTextField.CENTER);
                txtbox[r][c].setEditable(false);
            }
        }

        //new game button and reset current puzzle button
        JButton newgame = new JButton("New Game");
        JButton reset = new JButton("Reset");
        JButton solve = new JButton("Solve");

        //onclick for choosing new difficulty
        newgame.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                createDifficulty();
            }
        });

        //onclick to reset puzzle to new puzzle, same difficulty
        reset.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){

            }
        });

        //onclick to determine whether completed puzzle is correct or not
        solve.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){

            }
        });

        //adding all controls to respective places
        mainFrame.add(gridpanel,BorderLayout.CENTER);
        mainFrame.add(buttonpanel,BorderLayout.SOUTH);
        for(int r = 0; r < 9;r++){
            for(int c = 0; c < 9;c++){
                gridpanel.add(txtbox[r][c]);
            }
        }
        buttonpanel.add(newgame);
        buttonpanel.add(solve);
        buttonpanel.add(reset);

        //making main game frame visible on creation
        mainFrame.setVisible(true);
    }

    private void createDifficulty(){
        //main frame for difficulty selection

        JFrame difficultyFrame = new JFrame();
        difficultyFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        difficultyFrame.setLocationRelativeTo(null);
        difficultyFrame.setSize(150,150);
        difficultyFrame.setResizable(false);

        //button container panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3,1));

        //buttons to select difficulty
        int buttonWidth = 15;
        int buttonHeight = 10;
        JButton easyButton = new JButton("EASY");
        JButton mediumButton = new JButton("MEDIUM");
        JButton hardButton = new JButton("HARD");
        easyButton.setSize(buttonWidth,buttonHeight);
        mediumButton.setSize(buttonWidth,buttonHeight);
        hardButton.setSize(buttonWidth,buttonHeight);

        //easy difficulty selection on click
        easyButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                gamelogic.fillGrid();
                difficultyFrame.dispose();
            }
        });

        //adding controls to panels/frame
        difficultyFrame.add(buttonPanel);
        buttonPanel.add(easyButton);
        buttonPanel.add(mediumButton);
        buttonPanel.add(hardButton);

        //making difficulty screen visible on creation
        difficultyFrame.setVisible(true);
    }
}
