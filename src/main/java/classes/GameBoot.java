package classes;

import dto.RoundData;
import interfaces.Boot;

public class GameBoot implements Boot
{
    private Checkboard checkboard;
    private CouponCounter couponCounter;
    private int round = 0;

    public GameBoot()
    {
        checkboard = new Checkboard();
        couponCounter = new CouponCounter();
    }

    @Override
    public RoundData bootTheGame(int Fall)
    {
        int looprVal = 0;

        if(Fall == 1)
            looprVal = 25;
        else if(Fall == 2)
            looprVal = 50;
        else if(Fall == 3)
            looprVal = 100;
        else
        return null;

        for(int i = 0; i < looprVal; i++)
        {
         round++;
         checkboard.shuffleBoard();
        }
        int[][] currentBoard = checkboard.getCheckBoard();

        for(int i = 0; i < currentBoard.length; i++)
        {
            for(int j = 0; j < currentBoard.length; j++)
            {
                System.out.print(currentBoard[i][j]);
            }
            System.out.println();
        }

        return couponCounter.checkAllRound(currentBoard);
    }
}
