package classes;

import dto.RoundData;
import interfaces.Boot;

/**
 * <strong>GameBoot</strong> class<br>
 * In this class are injected two another classes {@link Checkerboard} and {@link CouponCounter}.
 * This fact allows to create many interesting operations like the method {@link GameBoot#bootTheGame(int)}
 * does.<br>
 * This class also helps to control the application in a higher level<br><br>
 * @author Karol Melak
 * @since 1.0
 */
public class GameBoot implements Boot
{
    private Checkerboard checkerboard;
    private CouponCounter couponCounter;
    private int round = 0;
    private int playerCollectedCoupons = 0;

    public GameBoot()
    {
        checkerboard = new Checkerboard();
        couponCounter = new CouponCounter();
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
     * <strong>Important</strong><br>
     * To simulate that user can collect the coupons after 25, 50 and 100 round
     * in this method created simulation that collect maximum value from the
     * checkerboard after 25, 50 and 100 round<br><br>
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
        RoundData lastRoundData = new RoundData();
        int looprVal = 0;

        if(Fall == 1)
            looprVal = 25;
        else if(Fall == 2)
            looprVal = 50;
        else if(Fall == 3)
            looprVal = 100;
        else
        return lastRoundData;

        for(int i = 0; i < looprVal; i++)
        {
            round++;
            lastRoundData = couponCounter.checkAllRound(checkerboard.shuffleCheckerboard());

            showCurrentCheckerboard();
        }

        int A = lastRoundData.getCoordinates().getCoordinateA();
        int B = lastRoundData.getCoordinates().getCoordinateB();
        int[][] arrayToModify = checkerboard.getCheckerBoard();

        playerCollectedCoupons += lastRoundData.getMAX();
        arrayToModify[A][B] = 0;
        checkerboard.setCheckerBoard(arrayToModify);

        return lastRoundData;
    }

    /**
     * This method clear window, after displays the current checkerboard and also returns<br>
     * the current checkerboard<br><br>
     * @return current checkerboard
     */
    public int[][] showCurrentCheckerboard()
    {
        clearConsole();

        int[][] currentBoard = checkerboard.getCheckerBoard();

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

    /**
    * This method displays current logs of all rounds
    * in suitable format in a console window
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

    /**
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

    public int getPlayerCollectedCoupons()
    {
        return playerCollectedCoupons;
    }
    public int getRound()
    {
        return round;
    }
}