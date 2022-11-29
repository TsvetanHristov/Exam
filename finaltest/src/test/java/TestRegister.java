import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestRegister {
   public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://shop.pragmatic.bg/");
    }

//    @AfterMethod
//    public void tearDown() {
//        driver.quit();
//    }

    @Test
    public static void testRegister(){
        driver.findElement(By.xpath("//*[@id='top-links']//li[2]//span[1]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='top-links']//li[2]//li[1]/a"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("input-firstname"))).sendKeys("Nqkoy");
        driver.findElement(By.cssSelector("#input-lastname")).sendKeys("Si");
        String prefix = RandomStringUtils.randomAlphabetic(7);
        String domainPrefix = RandomStringUtils.randomAlphabetic(4);
        String mainPrefix = RandomStringUtils.randomAlphabetic(3);
        String emailAdress = prefix + "@" + domainPrefix + "." + mainPrefix;
        driver.findElement(By.id("input-email")).sendKeys(emailAdress);
        String prefixNumber = RandomStringUtils.randomAlphabetic(7);
        String mobileNumber = "+359" + prefixNumber;
        driver.findElement(By.id("input-telephone")).sendKeys(mobileNumber);
        String password = RandomStringUtils.randomAscii(7);
        driver.findElement(By.id("input-password")).sendKeys(password);
        driver.findElement(By.id("input-confirm")).sendKeys(password);
        WebElement checkBoxPolicy = driver.findElement(By.xpath("//div[@class='pull-right']/input[1]"));
        if(!checkBoxPolicy.isSelected()){
            checkBoxPolicy.click();
        }
        driver.findElement(By.xpath("//div[@class='pull-right']/input[2]")).click();
        String finalStatus = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='content']/h1"))).getText();
        Assert.assertEquals(finalStatus, "Your Account Has Been Created!");


    }
}
