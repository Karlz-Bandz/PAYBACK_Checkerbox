import classes.StarterPack;

public class Main
{
    /*
    *        !IMPORTANT!
    * This application logic works correct always but is displayed correct only
    * when is run on Windows command line or IOS/Linux terminal.
    * It happens because private method clearConsole() inside the GameBoot class
    * doesn't work on any IDE console.
    *
    * To run in a console go to the command prompt and navigate to the directory
    * where your PAYBACK_Checkerboard file is saved using the "cd" command.
    * Compile your Java code by entering the command "javac Main.java" in src/main/java folder.
    * When code is compiled to run application enter the command "java Main"
    *
    * More information will be displayed when you run the program.
    * More details and descriptions can be found inside interfaces and
    * abstract classes.
     */
    public static void main(String[] args) throws Exception
    {
               StarterPack starterPack = new StarterPack();
               starterPack.open();
    }
}
