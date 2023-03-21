package classes;

import dto.Coordinate;
import dto.RoundData;
import interfaces.Boot;

/**
 * <strong>GameBoot</strong> class<br>
 * In this class are injected two another classes {@link Checkerboard} and {@link CouponCounter}.
 * This fact allows to create many interesting operations like the method {@link GameBoot#bootTheGame(int)}
 * does.<br>
 * This class also helps to control the application in higher level<br><br>
 * @author Karol Melak
 * @since 1.0
 */
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

    /**
    * <strong>This method simulates rounds in three different cases'</strong><br>
     * <ul>
     *     <li>case 1 - 25 rounds</li>
     *     <li>case 2 - 50 rounds</li>
     *     <li>case 3 - 100 rounds</li>
     * </ul>
    * When simulation has been finished method returns data with
    * all informations about points.<br><br>
    *
    * <strong>In all cases except 1,2 and 3 method does nothing and returns
    * RoundData object with all data set on null</strong>
     * <br><br>
     * @param Fall
     * @return {@link RoundData} object
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
