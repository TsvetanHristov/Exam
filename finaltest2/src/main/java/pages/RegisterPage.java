package pages;

import base.BasePage;
import dev.failsafe.internal.util.Assert;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Browser;
import utils.Wait;

public class RegisterPage extends BasePage {

    @FindBy(xpath = "//*[@id='top-links']//li[2]//span[1]")
    private static WebElement myAccount;

    @FindBy(xpath = "//*[@id='top-links']//li[2]//li[1]/a")
    private static WebElement registerOption;

    @FindBy(id = "input-firstname")
    private static WebElement firstNameInputField;

    @FindBy(id = "input-lastname")
    private static WebElement lastNameInputField;

    @FindBy(id = "input-email")
    private static WebElement emailInputField;

    @FindBy(id = "input-telephone")
    private static WebElement telephoneInputField;

    @FindBy(id = "input-password")
    private static WebElement passwordInputField;

    @FindBy(id = "input-confirm")
    private static WebElement confirmPasswordInputField;

    @FindBy(xpath = "//div[@class='pull-right']/input[1]")
    private static WebElement checkBoxPolicy;

    @FindBy(xpath = "//div[@class='pull-right']/input[2]")
    private static WebElement continueButton;

    @FindBy(xpath = "//div[@id='content']/h1")
    private static WebElement finalText;

    private static String loginPageUrl = "http://shop.pragmatic.bg/";

    static {
        PageFactory.initElements(Browser.driver, RegisterPage.class);
    }

    public static void goTo() {
        Browser.driver.get(loginPageUrl);
    }

    public static void clickMyAccount() {
        Wait.wait.until(ExpectedConditions.visibilityOf(myAccount));
        click(myAccount);
        Wait.wait.until(ExpectedConditions.visibilityOf(registerOption));
        click(registerOption);
    }

    public static void typeInFirstNameInputField(String firtsName) {
        Wait.wait.until(ExpectedConditions.visibilityOf(firstNameInputField));
        firstNameInputField.sendKeys(firtsName);
    }

    public static void typeInLastNameInputField(String secondName) {
        lastNameInputField.sendKeys(secondName);
    }

    public static void typeInEmailInputField() {
        String prefix = RandomStringUtils.randomAlphabetic(7);
        String domain = RandomStringUtils.randomAlphabetic(4);
        String main = RandomStringUtils.randomAlphabetic(3);
        String email = prefix + "@" + domain + "." + main;
        emailInputField.sendKeys(email);
    }

    public static void typeInTelephoneInputField() {
        String prefixNumber = RandomStringUtils.randomAlphabetic(7);
        String mobileNumber = "+359" + prefixNumber;
        telephoneInputField.sendKeys(mobileNumber);
    }

    public static void typeInPasswordInputField(String pass) {
        passwordInputField.sendKeys(pass);
    }

    public static void typeInConfirmPasswordInputField(String pass) {
        confirmPasswordInputField.sendKeys(pass);
    }

    public static void checkIfSelectAndClick() {
        if (!checkBoxPolicy.isSelected()) {
            checkBoxPolicy.click();
        }
    }

    public static void clickContinueButton() {
        click(continueButton);
    }

}