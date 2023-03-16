package classes;

import interfaces.Settingz;

public class Checkboard implements Settingz
{
    private int[][] checkBoard = new int[15][15];


    /*
   * Initialization of each checkBoard array element with value 1 happens
   * in constructor of class Checkboard. Value one imitates the Pointee ;)
    */

    public Checkboard()
    {
        for(int i = 0; i < 15; i++)
        {
            for(int j = 0; j < 15; j++)
            {
                checkBoard[i][j] = 1;
            }
        }
    }


    public int[][] getCheckBoard() {
        return this.checkBoard;
    }
}
