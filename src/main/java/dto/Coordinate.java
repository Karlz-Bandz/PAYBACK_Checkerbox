package dto;

public class Coordinate
{
    private int coordinateA;
    private int coordinateB;

    public Coordinate(int coordinateA, int coordinateB)
    {
        this.coordinateA = coordinateA;
        this.coordinateB = coordinateB;
    }

    public int getCoordinateA()
    {
        return coordinateA;
    }

    public int getCoordinateB()
    {
        return coordinateB;
    }
}