import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class GameLogic {
    private JTextField[][] txtbox = GameUI.txtbox;

    //method to fill each row with a random 1-9 with no repeats in the row
    public void fillGrid() {

        for (int r = 0; r < 9; r++) { //loop for each row
            ArrayList<String> numberchoice = new ArrayList<String>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"));
            int reduction = 0;
            int randomroll;

            for (int c = 0; c < 9; c++) { //loop for each column
                randomroll = (int) (Math.random() * (9 - reduction)); //formula to roll random number 1-9, set text box to that number, then remove that number from the pool of available numbers, as to not repeat any
                txtbox[r][c].setText(numberchoice.get(randomroll));
                numberchoice.remove(randomroll);
                reduction++;
            }

        }
    }
}
