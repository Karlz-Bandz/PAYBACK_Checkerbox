package classes;

import dto.Coordinate;
import dto.RoundData;
import interfaces.Counter;

import java.util.ArrayList;
import java.util.List;

/**
 * This class counts how many points are on the square with the MAX value
 * Checks coordinates of the MAX value
 * Sum all points on the checkbox.
 *
 * However, each object of this class collects data in three different lists
 * allCouponSums, allMaxCouponValues and allMaxCouponCoordinates.
 * It helps to check how the states of values changes after many interactions.
 */
public class CouponCounter implements Counter
{

    private List<Integer> allCouponSums;
    private List<Integer> allMaxCouponValues;
    private List<Coordinate> allMaxCouponCoordinates;



    public CouponCounter()
    {
        allCouponSums = new ArrayList<>();
        allMaxCouponValues = new ArrayList<>();
        allMaxCouponCoordinates = new ArrayList<>();
    }

    @Override
    public int sumCoupons(int[][] checkBoard)
    {

        int len = checkBoard.length;
        int sum = 0;


        for (int i = 0; i < len; i++)
        {
            for (int j = 0; j < len; j++)
            {
                if (checkBoard[i][j] != 0)
                    for (int x = 0; x < checkBoard[i][j]; x++)
                    {
                        sum += 1;
                    }
            }
        }
        allCouponSums.add(sum);

        return sum;
    }

    @Override
    public int findMAX(int[][] checkBoard)
    {
        int len = checkBoard.length;
        int MAX_VAL = 0;

        for (int i = 0; i < len; i++)
        {
            for (int j = 0; j < len; j++)
            {
                if(checkBoard[i][j] > MAX_VAL)
                {
                    MAX_VAL = checkBoard[i][j];
                }
            }
        }
        allMaxCouponValues.add(MAX_VAL);

        return MAX_VAL;
    }

    @Override
    public Coordinate findMAXCoordinates(int[][] checkBoard)
    {
        int len = checkBoard.length;
        int MAX_VAL = 0;
        int coordinateA = 0;
        int coordinateB = 0;
        Coordinate coordinate;

        for (int i = 0; i < len; i++)
        {
            for (int j = 0; j < len; j++)
            {
                if(checkBoard[i][j] > MAX_VAL)
                {
                    MAX_VAL = checkBoard[i][j];
                    coordinateA = i;
                    coordinateB = j;
                }
            }
        }
        coordinate = new Coordinate(coordinateA, coordinateB);
        allMaxCouponCoordinates.add(coordinate);

        return coordinate;
    }

    @Override
    public RoundData checkAllRound(int[][] checkBoard)
    {
        int sum = sumCoupons(checkBoard);
        int max = findMAX(checkBoard);
        Coordinate coordinates = findMAXCoordinates(checkBoard);

        RoundData roundData = new RoundData(sum,max,coordinates);

        return roundData;
    }



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
