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

    /**
     * This method refers to the methods<br>
     * {@link Checkerboard#shuffleWalls()}<br>
     * {@link Checkerboard#shuffleCorners()}<br>
     * {@link Checkerboard#shuffleKernel()}<br><br>
     *
     * As we know all of those methods at the end update the statement of
     * {@link Checkerboard#helperArr} so when all methods
     * are executed the {@link Checkerboard#helperArr} is ready to
     * be used as the main array and is assign as the new {@link Checkerboard#checkerBoard}
     * array.<br>
     * At the end all values of {@link Checkerboard#helperArr} are set to 0
     * and the current {@link Checkerboard#checkerBoard} is returned.
     * <br><br>
     *
     * @return current checkerboard int[][]
     */
    @Override
    public int[][] shuffleCheckerboard()
    {
        shuffleCorners();
        shuffleWalls();
        shuffleKernel();

        checkerBoard = helperArr;
        helperArr = new int[15][15];

        return this.checkerBoard;
    }

    /**
     * To protect all points located on the checkerboard's corners
     * from falling out of the checkerboard created an algorithm that change position
     * of each point in two random cases except two which could throw
     * the points out of the board.<br><br>
     *
     * All changes are saved in {@link Checkerboard#helperArr}
     */
    @Override
    protected void shuffleCorners()
    {
         rtCorner();
         ltCorner();
         rdCorner();
         ldCorner();
    }

    /**
     * To protect all points located on the edges of checkerboard
     * from falling out of checkerboard created an algorithm that change position
     * of each point in three random cases except the one which could throw
     * the points out of the board.<br><br>
     *
     * All changes are saved in {@link Checkerboard#helperArr helperArr}<br><br>
     *
     * In this method left the comments with threads
     * because with threads all methods together
     * inside the {@link Checkerboard#shuffleCheckerboard()} generated some errors
     * with array values
     */
    @Override
    protected void shuffleWalls()
    {
//            Runnable loop1 = new Runnable() {
//            @Override
//            public void run() {
                 shuffleTopWall();
//            }
//        };
//        Runnable loop2 = new Runnable() {
//            @Override
//            public void run() {
                shuffleBottomWall();
//            }
//        };
//        Runnable loop3 = new Runnable() {
//            @Override
//            public void run() {
                shuffleLeftWall();
//            }
//        };
//        Runnable loop4 = new Runnable() {
//            @Override
//            public void run() {
                 shuffleRightWall();
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

    /**
     * In this part of the checkerboard is not possible to fall by
     * any point out of the board so decided to iterate through
     * every element and change position of each points in the
     * four random cases up, down, left or right<br><br>
     *
     * All changes are saved in {@link Checkerboard#helperArr}
     */
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

    @Override
    protected void shuffleTopWall()
    {
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
    }

    @Override
    protected void shuffleBottomWall()
    {
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
    }

    @Override
    protected void shuffleLeftWall()
    {
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
    }

    @Override
    protected void shuffleRightWall()
    {
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
    }

    @Override
    protected void ltCorner()
    {
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
    }

    @Override
    protected void rtCorner()
    {
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
    }

    @Override
    protected void ldCorner()
    {
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
    }

    @Override
    protected void rdCorner()
    {
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
}