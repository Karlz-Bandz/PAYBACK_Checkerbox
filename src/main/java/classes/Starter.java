package classes;

import dto.RoundData;

public class Starter
{
    private GameBoot boot;

    public Starter(){
        boot = new GameBoot();
    }


    public void open(int Fall)
    {
            RoundData roundData = boot.bootTheGame(Fall);
            System.out.println();
            System.out.println("Round: " + boot.getRound() + "\n");
            System.out.println("All points: " + roundData.getSUM() + "\nMAX coupon: " + roundData.getMAX());
            System.out.println("Co-ordinates of MAX coupon: " + roundData.coordinatesFormat());
    }


}
