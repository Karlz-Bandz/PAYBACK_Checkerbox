package classes;

import dto.Coordinate;
import dto.RoundData;
import interfaces.Boot;

public class GameBoot implements Boot
{
    private Checkerboard checkerboard;
    private CouponCounter couponCounter;
    private int round = 0;

    public GameBoot()
    {
        checkerboard = new Checkerboard();
        couponCounter = new CouponCounter();
    }

    public int getRound()
    {
        return round;
    }

    /*
    * This method simulates rounds in three different cases'
    * case 1 - 25 rounds
    * case 2 - 50 rounds
    * case 3 - 100 rounds
    *
    * When simulation has been finished method returns data with
    * all informations about points.
    *
    * In cases except 1,2 and 3 method does nothing and returns
    * RoundData object with all data set with null
     */
    @Override
    public RoundData bootTheGame(int Fall)
    {
        int looprVal = 0;

        if(Fall == 1)
            looprVal = 25;
        else if(Fall == 2)
            looprVal = 50;
        else if(Fall == 3)
            looprVal = 100;
        else
        return new RoundData(0,0,new Coordinate(0,0));

        RoundData lastRoundData = new RoundData(0,0, new Coordinate(0,0));

        for(int i = 0; i < looprVal; i++)
        {
            clearConsole();
         round++;
         lastRoundData = couponCounter.checkAllRound(checkerboard.shuffleBoard());


         showCurrentCheckboard();
        }

        return lastRoundData;
    }

    @Override
    public int[][] showCurrentCheckboard()
    {
        clearConsole();
        int[][] currentBoard = checkerboard.getCheckBoard();

        for(int i = 0; i < currentBoard.length; i++)
        {
            for(int j = 0; j < currentBoard.length; j++)
            {
                System.out.print(currentBoard[i][j]+ " ");
            }
            System.out.println();
        }

        return currentBoard;
    }

    /*
    * This function displays current logs of all rounds
    * in suitable format in console
     */
    @Override
    public String displayAllRoundLogs()
    {
        StringBuilder logBuilder = new StringBuilder();
        logBuilder.append("\n\nRound  ");
        logBuilder.append("SUM  ");
        logBuilder.append("MAX Values  ");
        logBuilder.append("MAX Co-ordinates\n\n");

        for(int i = 0; i < couponCounter.getAllCouponSums().size(); i++)
        {
            logBuilder.append(i+1 + ".     ");
            logBuilder.append(couponCounter.getAllCouponSums().get(i) + "      ");
            logBuilder.append(couponCounter.getAllMaxCouponValues().get(i) + "           ");
            logBuilder.append("[" + couponCounter.getAllCoordinates().get(i).getCoordinateA() + ", " +
                    couponCounter.getAllCoordinates().get(i).getCoordinateB() + "]\n");
        }

        return logBuilder.toString();
    }


    /*
    * This method doesn't work on any IDE terminal. To see how it works you
    * have to run code on the local PC Terminal
     */
    private void clearConsole()
    {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Error occurred while clearing console: " + e.getMessage());
        }
    }
}
