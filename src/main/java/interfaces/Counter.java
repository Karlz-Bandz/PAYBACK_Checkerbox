package interfaces;

import dto.Coordinate;
import dto.RoundData;


/**
 * <strong>Counter</strong> interface<br>
 * <p>It is implemented by {@link classes.CouponCounter CouponCounter} class that is
 * responsible for processing and saving information about the progress
 * of each round. </p>
 */
public interface Counter
{
    int sumCoupons(int[][] checkBoard);

    int findMAX(int[][] checkBoard);

    Coordinate findMAXCoordinates(int[][] checkBoard);

    RoundData checkAllRound(int[][] checkBoard);
}
