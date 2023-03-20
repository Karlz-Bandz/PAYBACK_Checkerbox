package classes;

/**
 * <Strong>Checkerboard</Strong> class
 * <p>This class extends from {@link Board Board} abstract class and here are<br>
 * algorithms which shuffles points on checkerboard.</p>
 * <br>
 * @author Karol Melak
 * @since 1.0
 */

public class Checkerboard extends Board
{
    public Checkerboard()
    {
        super();
    }

    @Override
    public int[][] shuffleBoard()
    {

        shuffleCorners();
        shuffleWalls();
        shuffleKernel();

        checkerBoard = helperArr;
        helperArr = new int[15][15];

        return this.checkerBoard;
    }

    @Override
    protected void shuffleCorners()
    {
        /*
         * Left-Top Corner
         */
        int firstCorner = checkerBoard[0][0];

        if (firstCorner > 0)
        {
            for (int i = 0; i < firstCorner; i++)
            {
                int rnd = rand.nextInt(2) + 2;
                if (rnd == 2)
                    helperArr[0][1] += 1;
                else if (rnd == 3)
                    helperArr[1][0] += 1;
            }
        }

        /*
         * Right-Top Corner
         */
        int secondCorner = checkerBoard[0][14];

        if (secondCorner > 0)
        {
            for (int i = 0; i < secondCorner; i++)
            {
                int rnd = rand.nextInt(2) + 3;
                if (rnd == 3)
                    helperArr[1][14] += 1;
                else if (rnd == 4)
                    helperArr[0][13] += 1;
            }
        }

        /*
         * Left-Down Corner
         */
        int thirdCorner = checkerBoard[14][0];

        if (thirdCorner > 0)
        {
            for (int i = 0; i < thirdCorner; i++)
            {
                int rnd = rand.nextInt(2) + 1;
                if (rnd == 1)
                    helperArr[13][0] += 1;
                else if (rnd == 2)
                    helperArr[14][1] += 1;
            }
        }

        /*
         * Right-Down Corner
         */
        int fourCorner = checkerBoard[14][14];

        if (fourCorner > 0)
        {
            for (int i = 0; i < fourCorner; i++)
            {
                int rnd = rand.nextInt(2) + 1;
                if (rnd == 1)
                    helperArr[13][14] += 1;
                else if (rnd == 2)
                    helperArr[14][13] += 1;
            }
        }
    }

    /*
     * In this method I left the comments with threads
     * because with threads all methods together
     * inside the shuffleBoard() generates some errors
     * with array values
     */
    @Override
    protected void shuffleWalls()
    {
        /*
         * TOP
         */
//        Runnable loop1 = new Runnable() {
//            @Override
//            public void run() {
        for (int i = 1; i < 14; i++)
        {
            if (checkerBoard[0][i] != 0)
            {
                for (int j = 0; j < checkerBoard[0][i]; j++)
                {
                    int rander = rand.nextInt(3);

                    if (rander == 0)
                        helperArr[0][i - 1] += 1;
                    else if (rander == 1)
                        helperArr[1][i] += 1;
                    else if (rander == 2)
                        helperArr[0][i + 1] += 1;
                }
            }
        }
//            }
//        };

        /*
         * BOTTOM
         */
//        Runnable loop2 = new Runnable() {
//            @Override
//            public void run() {
        for (int i = 1; i < 14; i++)
        {
            if (checkerBoard[14][i] != 0)
            {
                for (int j = 0; j < checkerBoard[14][i]; j++)
                {
                    int rander = rand.nextInt(3);

                    if (rander == 0)
                        helperArr[14][i - 1] += 1;
                    else if (rander == 1)
                        helperArr[13][i] += 1;
                    else if (rander == 2)
                        helperArr[14][i + 1] += 1;
                }
            }
        }
//            }
//        };

        /*
         * LEFT
         */
//        Runnable loop3 = new Runnable() {
//            @Override
//            public void run() {
        for (int i = 1; i < 14; i++)
        {
            if (checkerBoard[i][0] != 0)
            {
                for (int j = 0; j < checkerBoard[i][0]; j++)
                {
                    int rander = rand.nextInt(3);

                    if (rander == 0)
                        helperArr[i - 1][0] += 1;
                    else if (rander == 1)
                        helperArr[i][1] += 1;
                    else if (rander == 2)
                        helperArr[i + 1][0] += 1;
                }
            }
        }
//            }
//        };

        /*
         * RIGHT
         */
//        Runnable loop4 = new Runnable() {
//            @Override
//            public void run() {
        for (int i = 1; i < 14; i++)
        {
            if (checkerBoard[i][14] != 0)
            {
                for (int j = 0; j < checkerBoard[i][14]; j++)
                {
                    int rander = rand.nextInt(3);

                    if (rander == 0)
                        helperArr[i - 1][14] += 1;
                    else if (rander == 1)
                        helperArr[i][13] += 1;
                    else if (rander == 2)
                        helperArr[i + 1][14] += 1;
                }
            }
        }
//            }
//        };
//        Thread thread1 = new Thread(loop1);
//        Thread thread2 = new Thread(loop2);
//        Thread thread3 = new Thread(loop3);
//        Thread thread4 = new Thread(loop4);
//
//        thread1.start();
//        thread2.start();
//        thread3.start();
//        thread4.start();
    }

    @Override
    protected void shuffleKernel()
    {
        for (int i = 1; i < 14; i++)
        {
            for (int j = 1; j < 14; j++)
            {
                if (checkerBoard[i][j] != 0)
                {
                    for (int x = 0; x < checkerBoard[i][j]; x++)
                    {
                        int randCoordinate = rand.nextInt(4);

                        if (randCoordinate == 0)
                            helperArr[i][j + 1] += 1;
                        else if (randCoordinate == 1)
                            helperArr[i + 1][j] += 1;
                        else if (randCoordinate == 2)
                            helperArr[i][j - 1] += 1;
                        else if (randCoordinate == 3)
                            helperArr[i - 1][j] += 1;
                    }
                }
            }
        }
    }


    public int[][] getCheckBoard()
    {
        return this.checkerBoard;
    }

    public int[][] getHelperArr()
    {
        return this.helperArr;
    }
}
