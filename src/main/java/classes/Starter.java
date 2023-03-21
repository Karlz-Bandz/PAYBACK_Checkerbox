package classes;

import java.util.Scanner;

/**
 * <strong>Starter</strong> abstract class<br>
 * This class is the final class where is defined all configuration
 * how the application should run.<br>
 * To see the bodies of all methods go to the {@link StarterPack} class<br><br>
 * @author Karol Melak
 * @since 1.0
 */
public abstract class Starter
{
    protected Scanner scanner;
    protected GameBoot boot;

    public Starter(){
        boot = new GameBoot();
        scanner = new Scanner(System.in);
    }

    public abstract void open();
    protected abstract void welcome();
    protected abstract void shooter(int Fall);
    protected abstract void displayLogs();
}
