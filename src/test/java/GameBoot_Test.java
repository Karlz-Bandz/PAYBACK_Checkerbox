import classes.GameBoot;
import dto.RoundData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class GameBoot_Test
{

    private GameBoot gameBoot = new GameBoot();

    @Test
    public void basic(){
        for(int i = 0; i < 10 ; i++)
        {

            System.out.println(i);
        }
    }

    @Test
    public void BootTheGame_Test()
    {
        int expectedRound = 25;
        int expectedSum = 225;

        /*
        * In this test case I boot the game with argument 1 it means
        * that method bootTheGame is set to execute 25 shuffles of
        * the board. GameBoot object saves round number and iterates
        * it after each shuffle.
        *
        * This method also returns RoundData object with the all current
        * round data so in this test also check correctness of the data.
         */

        RoundData testData = gameBoot.bootTheGame(1);
        System.out.println("Round: " + gameBoot.getRound());
        System.out.println("Sum of all points: " + testData.getSUM());
        System.out.println("MAX value: " + testData.getMAX());
        System.out.println("Coordinates of MAX: " + testData.coordinatesFormat());

        /*
        * In this test case which is out of the 1-3 the method does nothing
        * and should return empty RoundData object
         */

        RoundData testData2 = gameBoot.bootTheGame(5);
        System.out.println("Round: " + gameBoot.getRound());
        System.out.println("Sum of all points: " + testData2.getSUM());
        System.out.println("MAX value: " + testData2.getMAX());
        System.out.println("Coordinates of MAX: " + testData2.coordinatesFormat());

        Assertions.assertEquals(gameBoot.getRound(), expectedRound);
        Assertions.assertEquals(testData.getSUM(), expectedSum);
        Assertions.assertEquals(testData2.getSUM(), 0);

    }

    @Test
    public void ShowCurrentCheckboard_Test()
    {

        System.out.println("\nShowCurrentCheckboard_Test\n");
        System.out.println("Init Checkboard:\n");
        gameBoot.showCurrentCheckboard();


        RoundData testData = gameBoot.bootTheGame(1);
        System.out.println("\nCheckboard after 25 rounds:\n");
        gameBoot.showCurrentCheckboard();
        System.out.println();

        int expectedPoints = 225;
        int generatedPoints = testData.getSUM();

        Assertions.assertEquals(expectedPoints, generatedPoints);

    }

    @Test
    public void DisplayAllRoundLogs_Test()
    {
        gameBoot.bootTheGame(1);
        String test = gameBoot.displayAllRoundLogs();
        System.out.println(test);
        Assertions.assertFalse(test.equals(""));
    }
}
