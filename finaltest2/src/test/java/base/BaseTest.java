package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.Browser;
import utils.Wait;

public class BaseTest {

    @BeforeMethod
    public static void browserSetup() {
        Browser.setup();
        Wait.setupWait();
    }

//    @AfterMethod
//    public static void quit() {
//        Browser.tearDown();
//    }
}
