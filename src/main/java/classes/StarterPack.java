package classes;

import dto.RoundData;

/**
 * <strong>StarterPack</strong> class<br>
 * This class extends from {@link Starter} class and defines all methods.<br><br>
 * @author Karol Melak
 * @since 1.0
 */
public class StarterPack extends Starter
{
    public StarterPack(){
        super();
    }

    /**
     * This method is responsible for display opening message.
     */
    @Override
    public void open()
    {
        welcome();
        scanner.nextLine();
        boot.showCurrentCheckerboard();
        System.out.println("PRESS ENTER FOR THE NEXT 25 ROUNDS...");
        scanner.nextLine();
        shooter(1);
        System.out.println("PRESS ENTER FOR THE NEXT 25 ROUNDS...");
        scanner.nextLine();
        shooter(1);
        System.out.println("PRESS ENTER FOR THE NEXT 50 ROUNDS...");
        scanner.nextLine();
        shooter(2);
        System.out.println("PRESS ENTER TO SEE LOGS...");
        scanner.nextLine();
        displayLogs();
        System.out.println("PRESS ENTER TO STOP");
        scanner.nextLine();
    }

    /**
     * This method is responsible for display opening message
     */
    @Override
    protected void welcome()
    {
        System.out.println("\n\nWelcome to the Checkerboard application \n" +
                "This presentation shows how the program works in different cases.\n\n" +
                "1 step ------------- program will display init array 15x15\n" +
                "2 step ------------- program will shuffle the board 25 times\n" +
                "and display the current board, round, sum of all points on the board,\n" +
                "MAX value on the board and its co-ordinates. After all collect the MAX\n" +
                "value for the user and remove it from the checkerboard\n" +
                "3 step ------------- program will shuffle the board next 25 times and\n" +
                "does the same like in step 2\n" +
                "5 step ------------- program will shuffle the board next 50 times and\n" +
                "does the same like in step 2\n" +
                "Final extra step --- program will show the logs from each of 100 rounds\n\n" +
                "PRESS ENTER TO START...");
    }

    /**
     * This method firs shuffle the checkerboard in on of 1 to 3 cases. Everything is explained
     * in {@link GameBoot#bootTheGame(int)} documentation.<br>
     * When the checkerboard stop to shuffle, method displays information about the
     * current status of round<br>
     * @param Fall
     */
    @Override
    protected void shooter(int Fall)
    {
        RoundData roundData = boot.bootTheGame(Fall);
        System.out.println();
        System.out.println("Round: " + boot.getRound() + "\n");
        System.out.println("All points: " + roundData.getSUM() + "\nMAX coupon: " + roundData.getMAX());
        System.out.println("Co-ordinates of MAX coupon: " + roundData.coordinatesFormat());
        System.out.println("User has already collected " + boot.getPlayerCollectedCoupons() + " points!\n");
    }

    /**
     * This method uses {@link GameBoot#displayAllRoundLogs()} method and displays
     * its result onto the screen
     */
    @Override
    protected void displayLogs()
    {
        System.out.println(boot.displayAllRoundLogs());
    }
}
