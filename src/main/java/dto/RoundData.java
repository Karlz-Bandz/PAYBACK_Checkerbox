package dto;

public class RoundData
{

    private int SUM;
    private int MAX;
    private Coordinate coordinates;

    public RoundData(int SUM, int MAX, Coordinate coordinates)
    {
        this.SUM = SUM;
        this.MAX = MAX;
        this.coordinates = coordinates;
    }

    public int getSUM()
    {
        return SUM;
    }

    public int getMAX()
    {
        return MAX;
    }

    public Coordinate getCoordinates()
    {
        return coordinates;
    }
}
