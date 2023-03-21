package classes;

import dto.Coordinate;
import dto.RoundData;
import interfaces.Counter;

import java.util.ArrayList;
import java.util.List;

/**
 * <strong>CouponCounter</strong> class<br><br>
 * This class can:
 * <ul>
 *     <li>Get points are from the square with the MAX value</li>
 *     <li>Get coordinates of the square with the MAX value</li>
 *     <li>Sum all points located on the checkbox</li>
 * </ul>
 *
 * However, each object of this class collects data in three different lists
 * only/always when the {@link CouponCounter#checkAllRound(int[][]) checkAllRound} is used.<br>
 * Those lists are below:<br>
 * {@link CouponCounter#allCouponSums allCouponSums},<br>
 * {@link CouponCounter#allMaxCouponValues allMaxCouponValues},<br>
 * {@link CouponCounter#allMaxCouponCoordinates allMaxCouponCoordinates}<br>
 * It helps to check how the states of values changes after each round.
 * <br><br>
 * @author Karol Melak
 * @since 1.0
 */
public class CouponCounter implements Counter
{

    /**
    * Those {@link List lists} are needed to save and display logs
     */
    private List<Integer> allCouponSums;
    private List<Integer> allMaxCouponValues;
    private List<Coordinate> allMaxCouponCoordinates;

    public CouponCounter()
    {
        allCouponSums = new ArrayList<>();
        allMaxCouponValues = new ArrayList<>();
        allMaxCouponCoordinates = new ArrayList<>();
    }

    /**
     * @param checkerBoard
     * @return sum of all checkerboard points
     */
    @Override
    public int sumCoupons(int[][] checkerBoard)
    {
        int len = checkerBoard.length;
        int sum = 0;

        for (int i = 0; i < len; i++)
        {
            for (int j = 0; j < len; j++)
            {
                if (checkerBoard[i][j] != 0)
                    for (int x = 0; x < checkerBoard[i][j]; x++)
                    {
                        sum += 1;
                    }
            }
        }

        return sum;
    }

    /**
     * @param checkerBoard
     * @return max value found in checkerboard
     */
    @Override
    public int findMAX(int[][] checkerBoard)
    {
        int len = checkerBoard.length;
        int MAX_VAL = 0;

        for (int i = 0; i < len; i++)
        {
            for (int j = 0; j < len; j++)
            {
                if(checkerBoard[i][j] > MAX_VAL)
                {
                    MAX_VAL = checkerBoard[i][j];
                }
            }
        }

        return MAX_VAL;
    }

    /**
     * @param checkerBoard
     * @return {@link Coordinate} object
     */
    @Override
    public Coordinate findMAXCoordinates(int[][] checkerBoard)
    {
        int len = checkerBoard.length;
        int MAX_VAL = 0;
        int coordinateA = 0;
        int coordinateB = 0;
        Coordinate coordinate;

        for (int i = 0; i < len; i++)
        {
            for (int j = 0; j < len; j++)
            {
                if(checkerBoard[i][j] > MAX_VAL)
                {
                    MAX_VAL = checkerBoard[i][j];
                    coordinateA = i;
                    coordinateB = j;
                }
            }
        }
        coordinate = new Coordinate(coordinateA, coordinateB);

        return coordinate;
    }

    /**
     * This method refers to: <br>
     * {@link CouponCounter#sumCoupons(int[][])},<br>
     * {@link CouponCounter#findMAX(int[][])},<br>
     * {@link CouponCounter#findMAXCoordinates(int[][])}<br><br>
     *
     * Next step saves all returned values in:<br>
     * {@link CouponCounter#allCouponSums},<br>
     * {@link CouponCounter#allMaxCouponValues},<br>
     * {@link CouponCounter#allMaxCouponCoordinates}<br><br>
     *
     * At the end creates an object of {@link RoundData} class and adds
     * to constructor all returned values by referred method too and returns
     * {@link RoundData} object with the current round status.<br><br>
     *
     *
     * @param checkBoard
     * @return {@link RoundData} object
     */
    @Override
    public RoundData checkAllRound(int[][] checkBoard)
    {
        int sum = sumCoupons(checkBoard);
        int max = findMAX(checkBoard);
        Coordinate coordinates = findMAXCoordinates(checkBoard);

            allCouponSums.add(sum);
            allMaxCouponValues.add(max);
            allMaxCouponCoordinates.add(coordinates);

            RoundData roundData = new RoundData(sum,max,coordinates);

        return roundData;
    }

    /**
    Getters section
     */
    public List<Integer> getAllCouponSums()
    {
        return allCouponSums;
    }

    public List<Integer> getAllMaxCouponValues()
    {
        return allMaxCouponValues;
    }

    public List<Coordinate> getAllCoordinates()
    {
        return allMaxCouponCoordinates;
    }

    public String getAllMaxCouponCoordinates()
    {
        StringBuilder builderCoordinates = new StringBuilder();
        for(Coordinate coordinate: allMaxCouponCoordinates)
        {
            builderCoordinates.append("["+coordinate.getCoordinateA()+", "+coordinate.getCoordinateB()+"] ");
        }
        return builderCoordinates.toString();
    }
}
