package interfaces;

import dto.Coordinate;
import dto.RoundData;

public interface Counter
{
    int sumCoupons(int[][] checkBoard);

    int findMAX(int[][] checkBoard);

    Coordinate findMAXCoordinates(int[][] checkBoard);

    RoundData checkAllRound(int[][] checkBoard);
}
