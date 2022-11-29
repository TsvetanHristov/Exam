import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegisterPage;
import utils.Wait;

public class RegisterTest extends BaseTest {

    @Test
    public void testRegister(){
        RegisterPage.goTo();
        RegisterPage.clickMyAccount();
        RegisterPage.typeInFirstNameInputField("Nqkoy");
        RegisterPage.typeInLastNameInputField("Si");
        RegisterPage.typeInEmailInputField();
        RegisterPage.typeInTelephoneInputField();
        RegisterPage.typeInPasswordInputField("12345");
        RegisterPage.typeInConfirmPasswordInputField("12345");
        RegisterPage.checkIfSelectAndClick();
        RegisterPage.clickContinueButton();
        String textAftertOrder = Wait.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='content']/h1"))).getText();
        Assert.assertEquals(textAftertOrder , "Your Account Has Been Created!");
    }
}
