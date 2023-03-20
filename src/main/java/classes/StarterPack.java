package classes;

import dto.RoundData;

public class StarterPack extends Starter
{
    public StarterPack(){
        super();
    }

    @Override
    public void open()
    {

    }

    @Override
    protected void welcome()
    {
        System.out.println("Welcome to the Checkerboard application \n" +
                "This presentation shows how the program works in different\n" +
                "cases.\n\n" +
                "1 step ------------- program will display init array 15x15\n" +
                "2 step ------------- program will shuffle the board 25 times\n" +
                "and display the current board, round, sum of all points on the board,\n" +
                "MAX value on the board and its co-ordinates\n" +
                "3 step ------------- program will shuffle the board next 25 times and\n" +
                "does the same like in step 2\n" +
                "5 step ------------- program will shuffle the board next 50 times and\n" +
                "does the same like in step 2\n" +
                "Final extra step --- program will show the logs from each from 100 rounds\n\n" +
                "PRESS ANY BUTTON TO START...");
    }

    @Override
    protected void shooter(int Fall)
    {
        RoundData roundData = boot.bootTheGame(Fall);
        System.out.println();
        System.out.println("Round: " + boot.getRound() + "\n");
        System.out.println("All points: " + roundData.getSUM() + "\nMAX coupon: " + roundData.getMAX());
        System.out.println("Co-ordinates of MAX coupon: " + roundData.coordinatesFormat());
    }

    @Override
    protected void displayLogs()
    {
        System.out.println(boot.displayAllRoundLogs());
    }
}
