import classes.StarterPack;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

public class StarterPack_Test
{
    StarterPack testStarter = new StarterPack();

    @Test
    public void DisplayLogs_Test() throws Exception
    {
        Method welcomeMethodTest = StarterPack.class.getDeclaredMethod("displayLogs");
        welcomeMethodTest.setAccessible(true);

        welcomeMethodTest.invoke(testStarter);

    }

    @Test
    public void Shooter_Test() throws Exception
    {
        Method welcomeMethodTest = StarterPack.class.getDeclaredMethod("shooter", int.class);
        welcomeMethodTest.setAccessible(true);

        welcomeMethodTest.invoke(testStarter, 1);
    }

    @Test
    public void Welcome_Test() throws Exception
    {
        Method welcomeMethodTest = StarterPack.class.getDeclaredMethod("welcome");
        welcomeMethodTest.setAccessible(true);

        welcomeMethodTest.invoke(testStarter);
    }
}
