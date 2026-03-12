package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LoginPage extends BasePage {
    private By LoginAcess = By.className("fa-user");
    private By InputUser = By.id("user");
    private By InputPassword = By.id("password");
    private By Submit = By.id("btnLogin");

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void AcessQazando(){
        driver.get("https://www.automationpratice.com.br");
        wait.until(ExpectedConditions.elementToBeClickable(LoginAcess)).click();
    }

    public void EnterCredencials(String user, String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(InputUser)).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(InputUser)).sendKeys(user);

        wait.until(ExpectedConditions.visibilityOfElementLocated(InputPassword)).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated((InputPassword))).sendKeys(password);
    }

    public void LoginSumitt(){
        wait.until(ExpectedConditions.elementToBeClickable(Submit)).click();

    }

    public void CheckMessage(By element, String expectedMessage){
        String actualMessage = "";

        actualMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(element)).getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }


}
