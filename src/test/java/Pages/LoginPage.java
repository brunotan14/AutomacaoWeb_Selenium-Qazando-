package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;

public class LoginPage{
    public WebDriver driver;
    public WebDriverWait wait;

    private By LoginAcess = By.className("fa-user");
    private By InputUser = By.id("user");
    private By InputPassword = By.id("password");
    private By Submit = By.id("btnLogin");

    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
