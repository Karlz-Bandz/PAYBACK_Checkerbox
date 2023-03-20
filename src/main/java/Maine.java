import classes.GameBoot;
import classes.Starter;
import dto.RoundData;


public class Maine
{

    public static void main(String[] args) throws Exception
    {
        Starter starter = new Starter();

        starter.open(1);
        Thread.sleep(4000);
        starter.open(1);
        Thread.sleep(4000);
        starter.open(2);


    }
}
