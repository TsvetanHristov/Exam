package base;

import org.openqa.selenium.WebElement;

public class BasePage {

    protected static void click(WebElement element) {
        element.click();
    }

    protected static void sendKeys(WebElement element){
        element.sendKeys();
    }
}
