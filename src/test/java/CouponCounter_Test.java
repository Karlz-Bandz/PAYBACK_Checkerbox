import classes.Checkboard;
import classes.CouponCounter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CouponCounter_Test
{

    private CouponCounter couponCounterTest = new CouponCounter();
    private Checkboard checkboardTest = new Checkboard();

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
        System.out.println(sum);

        Assertions.assertEquals(sum, expectedSum);

        /*
        * Simple Test
         */
        testArr = new int[15][15];
        testArr[0][0] = 1;
        testArr[11][13] = 1;
        expectedSum = 2;

        sum = couponCounterTest.sumCoupons(testArr);
        System.out.println(sum);

        Assertions.assertEquals(sum, expectedSum);

        /*
        * allCouponSum List Test
        * In this case CouponCounter{allCouponSums=[225, 2]
         */
        System.out.println(couponCounterTest.toString());
    }
}
