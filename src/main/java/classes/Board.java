package classes;

/**
 * <strong>Board</strong> abstract class
 * <p>The core of application. From this abstract class {@link Checkerboard Checkerboard} inherits</p>
 * <p>Here we can find very important methods like <br>
 * {@link Board#shuffleWalls()}<br>
 * {@link Board#shuffleCorners()}<br>
 * {@link Board#shuffleKernel()}<br>
 * {@link Board#shuffleCheckerboard()}<br></p><br>
 *
 * @author Karol Melak
 * @since 1.0
 */
public abstract class Board
{

    protected int[][] checkerBoard;
    protected int[][] helperArr;
    protected java.util.Random rand;

    /**
     * In the constructor all checkerboard squares are<br>
     * initialized with the value 1 that imitates the pointee ;)
     */
    public Board()
    {
        this.checkerBoard = new int[15][15];
        this.helperArr = new int[15][15];
        this.rand = new java.util.Random();
        for (int i = 0; i < 15; i++)
        {
            for (int j = 0; j < 15; j++)
            {
                checkerBoard[i][j] = 1;
            }
        }
    }

    public abstract int[][] shuffleCheckerboard();

    protected abstract void shuffleCorners();

    protected abstract void shuffleWalls();

    protected abstract void shuffleKernel();

    protected abstract void shuffleTopWall();

    protected abstract void shuffleBottomWall();

    protected abstract void shuffleLeftWall();

    protected abstract void shuffleRightWall();

    protected abstract void ltCorner();

    protected abstract void rtCorner();

    protected abstract void ldCorner();

    protected abstract void rdCorner();

    public void setCheckerBoard(int[][] checkerBoard)
    {
        this.checkerBoard = checkerBoard;
    }

    public int[][] getCheckerBoard()
    {
        return this.checkerBoard;
    }

    public int[][] getHelperArr()
    {
        return this.helperArr;
    }
}