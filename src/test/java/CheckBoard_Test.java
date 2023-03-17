import classes.Checkboard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CheckBoard_Test
{
    private Checkboard checkboardTest = new Checkboard();

    @Test
    public void ShuffleCornersTest()
    {
        checkboardTest.shuffleCorners();
        int[][] testHelper = checkboardTest.getHelperArr();
        int allPointaCounter = 0;
        int allExpectedPoints = 4;

        for(int i = 0; i < 15; i++)
        {
            for(int j = 0; j < 15; j++)
            {
                if(testHelper[i][j] != 0)
                {
                    for(int x = 0; x < testHelper[i][j]; x++)
                        allPointaCounter += 1;
                }
            }
        }
        Assertions.assertEquals(allPointaCounter, allExpectedPoints);
    }
}
