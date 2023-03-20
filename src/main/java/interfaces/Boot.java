package interfaces;

import dto.RoundData;

public interface Boot
{
   RoundData bootTheGame(int Fall);

   int[][] showCurrentCheckboard();

   String displayAllRoundLogs();
}
