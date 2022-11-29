package utils;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Wait {
    public static WebDriverWait wait;
    public static WebDriverWait setupWait() {
        wait = new WebDriverWait(Browser.driver, Duration.ofSeconds(10));
        return wait;
    }
}
