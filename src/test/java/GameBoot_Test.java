import classes.GameBoot;
import dto.RoundData;
import org.junit.jupiter.api.Test;

public class GameBoot_Test
{

    private GameBoot gameBoot = new GameBoot();

    @Test
    public void BootTheGame_Test()
    {
        RoundData testData = gameBoot.bootTheGame(2);
        System.out.println("Round: " + gameBoot.getRound());
        System.out.println("Sum of all points: " + testData.getSUM());
        System.out.println("MAX value: " + testData.getMAX());
        System.out.println("Coordinates of MAX: " + testData.coordinatesFormat());

    }
}
