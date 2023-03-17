import classes.Checkboard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

public class CheckBoard_Test
{
    private Checkboard checkboardTest = new Checkboard();

    @Test
    public void ShuffleCornersTest() throws Exception
    {
        Method shuffleCornerTest = Checkboard.class.getDeclaredMethod("shuffleCorners");
        shuffleCornerTest.setAccessible(true);

        shuffleCornerTest.invoke(checkboardTest);

        int[][] testHelper = checkboardTest.getHelperArr();
        int allPointCounter = 0;
        int allExpectedPoints = 4;

        for(int i = 0; i < 15; i++)
        {
            for(int j = 0; j < 15; j++)
            {
                System.out.print(testHelper[i][j]);
                if(testHelper[i][j] != 0)
                {
                    for(int x = 0; x < testHelper[i][j]; x++)
                        allPointCounter += 1;
                }
            }
            System.out.println();
        }

        Assertions.assertEquals(allPointCounter, allExpectedPoints);
    }

    @Test
    public void ShuffleWalls_Test() throws Exception
    {
     Method shuffleWallsTest = Checkboard.class.getDeclaredMethod("shuffleWalls");
     shuffleWallsTest.setAccessible(true);

     shuffleWallsTest.invoke(checkboardTest);

     int[][] testing = checkboardTest.getHelperArr();
     int allExpectedPoints = 26;
     int allGeneratedPoints = 0;

     for (int i = 0; i < 15; i++)
     {
         for(int j = 0; j < 15 ; j++)
         {
             System.out.print(testing[i][j]);
             if(testing[i][j] != 0)
             {
                 for(int x = 0; x < testing[i][j]; x++)
                     allGeneratedPoints += 1;
             }
         }
         System.out.println();
     }

     Assertions.assertEquals(allExpectedPoints, allGeneratedPoints);
    }
}
