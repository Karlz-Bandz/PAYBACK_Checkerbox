import classes.GameBoot;
import classes.StarterPack;

/**
 *           <strong>!IMPORTANT!</strong>
 * <p>The application logic always works correct, but it is displayed correct only
 * when is run on Windows command line or IOS/Linux terminal.
 * It happens because private method {@link GameBoot#clearConsole() clearConsole} inside the {@link GameBoot} class
 * doesn't work on any IDE console.</p>
 *
 * <p>To run in a console go to the command prompt and navigate to the directory
 * where your <strong>PAYBACK_Checkerboard</strong> file is saved using the "cd" command.
 * Compile your Java code by entering the command "javac Main.java" in src/main/java folder.
 * When code has been already compiled, to run application enter the command "java Main"</p>
 *
 * <p>More information will be displayed when you run the program.<br>
 * More details and descriptions can be found inside interfaces and
 * classes documentation.</p><br><br>
 * @author Karol Melak
 */
public class Main
{
    public static void main(String[] args) throws Exception
    {
        new StarterPack().open();
    }
}