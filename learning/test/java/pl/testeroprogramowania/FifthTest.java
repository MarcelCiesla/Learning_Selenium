package pl.testeroprogramowania;

import net.bytebuddy.build.Plugin;
import org.testng.annotations.Test;

public class FifthTest {

    // priortety testów, domyślna to 0

    @Test(priority = 2)
    public void firstTest () {
        System.out.println("I am first test");

    }

    @Test(priority = 0)
    public void secondTest () {
        System.out.println("I am second test");

    }

    @Test(priority = 1)
    public void thirdTest () {
        System.out.println("I am third test");

    }

}
