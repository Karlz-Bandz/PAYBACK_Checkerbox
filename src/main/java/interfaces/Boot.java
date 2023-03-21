package interfaces;

import dto.RoundData;

/**
 * <strong>Boot</strong> interface<br>
 * It is implemented by {@link classes.GameBoot GameBoot} class that is responsible for
 * controlling the entire class management process which uses:<br>
 * {@link classes.Checkerboard},<br>
 * {@link classes.CouponCounter}
 */
public interface Boot
{
   RoundData bootTheGame(int Fall);

   int[][] showCurrentCheckerboard();

   String displayAllRoundLogs();
}
