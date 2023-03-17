import classes.Checkboard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

public class CheckBoard_Test {

    private int pointerCounter(int[][] testedArray) {

        int allPointCounter = 0;

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {

                if (testedArray[i][j] != 0) {
                    for (int x = 0; x < testedArray[i][j]; x++)
                        allPointCounter += 1;
                }
            }

        }
        return allPointCounter;
    }

    private void displayer(int[][] testedArray) {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                System.out.print(testedArray[i][j]);
            }
            System.out.println();
        }
    }


    @Test
    public void ShuffleCorners_Test() throws Exception {
        Checkboard checkboardTest = new Checkboard();

        Method shuffleCornerTest = Checkboard.class.getDeclaredMethod("shuffleCorners");
        shuffleCornerTest.setAccessible(true);

        shuffleCornerTest.invoke(checkboardTest);

        int[][] testHelper = checkboardTest.getHelperArr();
        int allPointCounter = pointerCounter(testHelper);
        int allExpectedPoints = 4;

        /*
         * This test check if some value is not disappeared
         * during the algorithm is processing
         */
        Assertions.assertEquals(allPointCounter, allExpectedPoints);
    }

    @Test
    public void ShuffleWalls_Test() throws Exception {

        Checkboard checkboardTest1 = new Checkboard();

        Method shuffleWallsTest = Checkboard.class.getDeclaredMethod("shuffleWalls");
        shuffleWallsTest.setAccessible(true);

        shuffleWallsTest.invoke(checkboardTest1);

        int[][] testing = checkboardTest1.getHelperArr();
        int allExpectedPoints = 52;
        int allGeneratedPoints = pointerCounter(testing);

        /*
         * This test check if some value is not disappeared
         * during the algorithm is processing
         */
        Assertions.assertEquals(allExpectedPoints, allGeneratedPoints);
    }

    @Test
    public void shuffleKernel_Test() throws Exception {

        Checkboard checkboardTest = new Checkboard();

        Method shuffleKernelTest = Checkboard.class.getDeclaredMethod("shuffleKernel");
        shuffleKernelTest.setAccessible(true);

        shuffleKernelTest.invoke(checkboardTest);

        int[][] testBoardKernel = checkboardTest.getHelperArr();
        int allExpectedPoints = 169;
        int allGeneratedPoints = pointerCounter(testBoardKernel);

        /*
         * This test check if some value is not disappeared
         * during the algorithm is processing
         */
        Assertions.assertEquals(allExpectedPoints, allGeneratedPoints);
    }

    @Test
    public void ShuffleBoard_Test() {
        Checkboard checkboardTest = new Checkboard();

        int allExpectedPoints = 225;
        int[][] test = checkboardTest.shuffleBoard();
        int allGeneratedPoints = pointerCounter(test);


        Assertions.assertEquals(allExpectedPoints, allGeneratedPoints);

        for (int i = 0; i < 20; i++) {
            checkboardTest.shuffleBoard();

        }

        test = checkboardTest.shuffleBoard();
        allGeneratedPoints = pointerCounter(test);

        displayer(test);

        Assertions.assertEquals(allExpectedPoints, allGeneratedPoints);
    }
}
