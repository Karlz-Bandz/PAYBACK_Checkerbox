import classes.Checkerboard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

/**
 * <strong>Checkerboard_Test</strong>
 */
public class Checkerboard_Test
{
    private Checkerboard checkerboardTest = new Checkerboard();

    @Test
    public void ShuffleCorners_Test() throws Exception
    {
        Method shuffleCornerTest = Checkerboard.class.getDeclaredMethod("shuffleCorners");
        shuffleCornerTest.setAccessible(true);

        shuffleCornerTest.invoke(checkerboardTest);

        int[][] testHelper = checkerboardTest.getHelperArr();
        int allPointCounter = pointerCounter(testHelper);
        int allExpectedPoints = 4;

        /*
         * This test check if some value was not disappeared
         * during the algorithm was processing
         */
        Assertions.assertEquals(allPointCounter, allExpectedPoints);
    }

    @Test
    public void ShuffleWalls_Test() throws Exception
    {
        Method shuffleWallsTest = Checkerboard.class.getDeclaredMethod("shuffleWalls");
        shuffleWallsTest.setAccessible(true);

        shuffleWallsTest.invoke(checkerboardTest);

        int[][] testing = checkerboardTest.getHelperArr();
        int allExpectedPoints = 52;
        int allGeneratedPoints = pointerCounter(testing);

        /*
         * This test check if some value was not disappeared
         * during the algorithm was processing
         */
        Assertions.assertEquals(allExpectedPoints, allGeneratedPoints);
    }

    @Test
    public void ShuffleKernel_Test() throws Exception
    {
        Method shuffleKernelTest = Checkerboard.class.getDeclaredMethod("shuffleKernel");
        shuffleKernelTest.setAccessible(true);

        shuffleKernelTest.invoke(checkerboardTest);

        int[][] testBoardKernel = checkerboardTest.getHelperArr();
        int allExpectedPoints = 169;
        int allGeneratedPoints = pointerCounter(testBoardKernel);

        /*
         * This test check if some value was not disappeared
         * during the algorithm was processing
         */
        Assertions.assertEquals(allExpectedPoints, allGeneratedPoints);
    }

    /**
     * This test is very important because the {@link Checkerboard#shuffleCheckerboard()} method
     * refers to all methods inside the {@link Checkerboard}. That means if the test is passed
     * everything else should be correct
     */
    @Test
    public void ShuffleCheckerboard_Test()
    {
        Checkerboard checkerboardMainTest = new Checkerboard();

        int allExpectedPoints = 225;
        int[][] test = checkerboardMainTest.shuffleCheckerboard();
        int allGeneratedPoints = pointerCounter(test);

        //Test after one shuffle
        Assertions.assertEquals(allExpectedPoints, allGeneratedPoints);

        for (int i = 0; i < 20; i++)
        {
           test = checkerboardMainTest.shuffleCheckerboard();
        }

        allGeneratedPoints = pointerCounter(test);

        displayer(test);

        //Test after next 20 shuffles
        Assertions.assertEquals(allExpectedPoints, allGeneratedPoints);
    }

    private int pointerCounter(int[][] testedArray)
    {
        int allPointCounter = 0;

        for (int i = 0; i < 15; i++)
        {
            for (int j = 0; j < 15; j++)
            {
                if (testedArray[i][j] != 0)
                {
                    for (int x = 0; x < testedArray[i][j]; x++)
                        allPointCounter += 1;
                }
            }
        }
        return allPointCounter;
    }

    private void displayer(int[][] testedArray)
    {
        for (int i = 0; i < 15; i++)
        {
            for (int j = 0; j < 15; j++)
            {
                System.out.print(testedArray[i][j] + " ");
            }
            System.out.println();
        }
    }
}