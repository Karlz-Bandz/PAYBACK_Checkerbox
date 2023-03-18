import classes.Checkboard;
import classes.CouponCounter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CouponCounter_Test
{

    private CouponCounter couponCounterTest = new CouponCounter();
    private Checkboard checkboardTest = new Checkboard();

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
        Assertions.assertEquals(expectedMax2,testMax2);

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
