import classes.GameBoot;
import dto.RoundData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameBoot_Test
{

    private GameBoot gameBoot = new GameBoot();

    @Test
    public void BootTheGame_Test()
    {
        int expectedRound = 25;
        int expectedSum = 225;

        RoundData testData = gameBoot.bootTheGame(1);
        System.out.println("Round: " + gameBoot.getRound());
        System.out.println("Sum of all points: " + testData.getSUM());
        System.out.println("MAX value: " + testData.getMAX());
        System.out.println("Coordinates of MAX: " + testData.coordinatesFormat());

        RoundData testData2 = gameBoot.bootTheGame(5);
        System.out.println("Round: " + gameBoot.getRound());
        System.out.println("Sum of all points: " + testData2.getSUM());
        System.out.println("MAX value: " + testData2.getMAX());
        System.out.println("Coordinates of MAX: " + testData2.coordinatesFormat());

        System.out.println(gameBoot.displayAllRoundLogs());

        Assertions.assertEquals(gameBoot.getRound(), expectedRound);
        Assertions.assertEquals(testData.getSUM(), expectedSum);
        Assertions.assertEquals(testData2.getSUM(), 0);

    }
}
