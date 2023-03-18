package interfaces;

import dto.Coordinate;

public interface Counter
{
    int sumCoupons(int[][] checkBoard);

    int findMAX(int[][] checkBoard);

    Coordinate findMAXCoordinates(int[][] checkBoard);
}
