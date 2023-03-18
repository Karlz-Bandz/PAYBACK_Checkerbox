import classes.Checkboard;
import classes.CouponCounter;
import dto.Coordinate;
import dto.RoundData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CouponCounter_Test
{

    private CouponCounter couponCounterTest = new CouponCounter();
    private Checkboard checkboardTest = new Checkboard();

    @Test
    public void CheckAllRound_Test()
    {
        int[][] testArr = new int[15][15];
        testArr[0][0] = 4;
        testArr[3][8] = 1;
        testArr[12][1] = 44;
        testArr[13][14] = 32;

        int expectedSum1 = 81;
        int expectedMax1 = 44;
        Coordinate expectedMaxCoordinates1 = new Coordinate(12,1);

        /*
        * checkAllRound method counts all needed values and
        * returns RoundData object with Max, Sum and Coordinates of Max value
         */
        RoundData TestData = couponCounterTest.checkAllRound(testArr);
        Coordinate testCoordinates = TestData.getCoordinates();

        Assertions.assertEquals(TestData.getSUM(), expectedSum1);
        Assertions.assertEquals(TestData.getMAX(), expectedMax1);
        Assertions.assertEquals(testCoordinates.getCoordinateA(), expectedMaxCoordinates1.getCoordinateA());
        Assertions.assertEquals(testCoordinates.getCoordinateB(),expectedMaxCoordinates1.getCoordinateB());

        /*
        * All Lists inside CouponCounter class with its data
         */
        System.out.println("CheckAllRound_Test");
        System.out.println(couponCounterTest.getAllMaxCouponCoordinates());
        System.out.println(couponCounterTest.getAllCouponSums());
        System.out.println(couponCounterTest.getAllMaxCouponValues());
    }

    @Test
    public void FindMAXCoordinates_Test()
    {
        int[][] testArr = new int[15][15];
        testArr[0][0] = 4;
        testArr[3][8] = 1;
        testArr[12][1] = 44;
        testArr[13][14] = 32;

        int[][] testArr2 = new int[15][15];
        testArr2[1][1] = 43;
        testArr2[3][0] = 300;
        testArr2[14][1] = 3;
        testArr2[12][14] = 222;

        Coordinate testMAXCoordinate1 = couponCounterTest.findMAXCoordinates(testArr);
        Coordinate expectedCoordinate1 = new Coordinate(12, 1);

        Coordinate testMAXCoordinate2 = couponCounterTest.findMAXCoordinates(testArr2);
        Coordinate expectedCoordinate2 = new Coordinate(3, 0);

        Assertions.assertEquals(testMAXCoordinate1.getCoordinateA(), expectedCoordinate1.getCoordinateA());
        Assertions.assertEquals(testMAXCoordinate1.getCoordinateB(), expectedCoordinate1.getCoordinateB());

        Assertions.assertEquals(testMAXCoordinate2.getCoordinateA(), expectedCoordinate2.getCoordinateA());
        Assertions.assertEquals(testMAXCoordinate2.getCoordinateB(), expectedCoordinate2.getCoordinateB());

        /*
         * allCouponSum List Test
         * In this case CouponCounter{allMaxCouponCoordinates=[12, 1][3,0]
         */
        System.out.println("FindMaxCoordinates_Test");
        System.out.println(couponCounterTest.getAllMaxCouponCoordinates());
    }

    @Test
    public void FindMAX_Test()
    {
        int[][] testArr = new int[15][15];
        testArr[0][0] = 4;
        testArr[3][8] = 1;
        testArr[12][1] = 44;
        testArr[13][14] = 32;

        int[][] testArr2 = new int[15][15];
        testArr2[1][1] = 43;
        testArr2[3][0] = 122;
        testArr2[14][1] = 3;
        testArr2[12][14] = 222;

        int testMax = couponCounterTest.findMAX(testArr);
        int expectedMax = 44;

        int testMax2 = couponCounterTest.findMAX(testArr2);
        int expectedMax2 = 222;

        Assertions.assertEquals(expectedMax, testMax);
        Assertions.assertEquals(expectedMax2, testMax2);

        /*
         * allCouponSum List Test
         * In this case CouponCounter{allMaxCouponValues=[44, 222]
         */
        System.out.println("FindMax_Test");
        System.out.println(couponCounterTest.getAllMaxCouponValues());
    }

    @Test
    public void SumCoupons_Test()
    {
        /*
         * Classic test
         */
        int sum = 0;
        int expectedSum = 225;

        for (int i = 0; i < 25; i++)
        {
            checkboardTest.shuffleBoard();
        }

        int[][] testArr = checkboardTest.getCheckBoard();
        sum = couponCounterTest.sumCoupons(testArr);

        Assertions.assertEquals(sum, expectedSum);

        /*
         * Simple Test
         */
        testArr = new int[15][15];
        testArr[0][0] = 1;
        testArr[11][13] = 1;
        expectedSum = 2;

        sum = couponCounterTest.sumCoupons(testArr);

        Assertions.assertEquals(sum, expectedSum);

        /*
         * allCouponSum List Test
         * In this case CouponCounter{allCouponSums=[225, 2]
         */
        System.out.println("SumCoupons_Test");
        System.out.println(couponCounterTest.getAllCouponSums());
    }
}
