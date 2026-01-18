package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {
    public WebDriver driver;
    public WebDriverWait wait;


    String URL = "https://www.automationpratice.com.br";
    private By RegisterAcess = By.className("fa-lock");
    private By Username = By.id("user");
    private By Email = By.id("email");
    private By password = By.id("password");
    private By Submit = By.id("btnRegister");

    public RegisterPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void AcessRegister(){
        driver.get(URL);
        wait.until(ExpectedConditions.elementToBeClickable(RegisterAcess)).click();
    }

    public void FillCredencials(String name, String email, String senha){
        wait.until(ExpectedConditions.visibilityOfElementLocated(Username)).sendKeys(name);
        wait.until(ExpectedConditions.visibilityOfElementLocated(Email)).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(password)).sendKeys(senha);

    }

    public void RegisterSubmitt(){
        wait.until(ExpectedConditions.elementToBeClickable(Submit)).click();
    }




}
