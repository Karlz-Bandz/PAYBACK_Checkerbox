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
        int sum = 0;
        int expectedSum = 225;

        for (int i = 0; i < 25; i++)
        {
            checkboardTest.shuffleBoard();
        }

        int[][] testArr = checkboardTest.getCheckBoard();
        sum = couponCounterTest.sumCoupons(testArr);

        Assertions.assertEquals(sum, expectedSum);
    }
}
