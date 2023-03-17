package classes;

import interfaces.Settingz;

public class Checkboard implements Settingz
{
    private int[][] checkBoard = new int[15][15];
    private int[][] helperArr = new int[15][15];
    private java.util.Random rand = new java.util.Random();


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


    @Override
    public int[][] shuffleBoard()
    {

        return  checkBoard;
    }

    @Override
    public void shuffleCorners()
    {
        /*
        * Left-Top Corner
         */
        int firstCorner = checkBoard[0][0];

        if(firstCorner > 0)
        {
            for(int i = 0; i < firstCorner; i++)
            {
                int rnd = rand.nextInt(2) + 2;
                if(rnd == 2)
                    helperArr[0][1] += 1;
                else if(rnd == 3)
                    helperArr[1][0] += 1;
            }
        }

        /*
        * Right-Top Corner
         */
        int secondCorner = checkBoard[0][14];

        if(secondCorner > 0)
        {
            for(int i = 0; i < secondCorner; i++)
            {
                int rnd = rand.nextInt(2) + 3;
                if(rnd == 3)
                    helperArr[1][14] += 1;
                else if(rnd == 4)
                    helperArr[0][13] += 1;
            }
        }

        /*
        * Left-Down Corner
         */
        int thirdCorner = checkBoard[14][0];

        if(thirdCorner > 0)
        {
            for(int i = 0; i < thirdCorner; i++)
            {
                int rnd = rand.nextInt(2) + 1;
                if(rnd == 1)
                    helperArr[13][0] += 1;
                else if(rnd == 2)
                    helperArr[14][1] += 1;
            }
        }

        /*
        * Right-Down Corner
         */
        int fourCorner = checkBoard[14][14];

        if(fourCorner > 0)
        {
            for(int i = 0; i < fourCorner; i++)
            {
                int rnd = rand.nextInt(2) + 1;
                if(rnd == 1)
                    helperArr[13][14] += 1;
                else if(rnd == 2)
                    helperArr[14][13] += 1;
            }
        }
    }


    public int[][] getCheckBoard()
    {
        return this.checkBoard;
    }
    public int[][] getHelperArr()
    {
        return this.helperArr;
    }


}
