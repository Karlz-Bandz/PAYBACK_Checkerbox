import classes.Checkboard;

import java.util.Arrays;

public class CheckboardMain {
    public static void main(String[] args) {

        //First Test
        Checkboard checkboard = new Checkboard();

        int[][] myArr = checkboard.getCheckBoard();

        for(int i = 0; i < 15; i++)
        {
            for(int j = 0; j < 15; j++)
            {
                System.out.print(myArr[i][j]);
            }
            System.out.println();
        }








    }
}
