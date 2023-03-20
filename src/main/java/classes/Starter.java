package classes;

import java.util.Scanner;

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
