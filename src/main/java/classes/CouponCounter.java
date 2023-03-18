package classes;

import dto.Coordinates;
import interfaces.Counter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
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
    private HashMap<Integer, Coordinates> allMaxCouponCoordinates;

    @Override
    public String toString()
    {
        return "CouponCounter{" +
                "allCouponSums=" + allCouponSums +
                '}';
    }

    public CouponCounter()
    {
        allCouponSums = new ArrayList<>();
        allMaxCouponValues = new ArrayList<>();
        allMaxCouponCoordinates = new HashMap<>();
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
        return 0;
    }
}
