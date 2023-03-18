import classes.GameBoot;

public class Maine
{
    public static void main(String[] args)
    {

        GameBoot boot = new GameBoot();
        boot.showCurrentCheckboard();

        System.out.println();

        boot.bootTheGame(1);
        boot.showCurrentCheckboard();

    }
}
