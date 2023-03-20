package classes;

public abstract class Starter
{
    protected GameBoot boot;

    public Starter(){
        boot = new GameBoot();
    }

    public abstract void open();
    protected abstract void welcome();
    protected abstract void shooter(int Fall);
    protected abstract void displayLogs();
}
