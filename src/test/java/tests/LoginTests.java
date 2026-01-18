package tests;

import Pages.LoginPage;
import base.BaseTest;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;


public class LoginTests extends BaseTest {

    private LoginPage loginPage;
    // cada teste recebe uma nova instancia atraves do before, que ao inicializar, garante isolamento entre cenarios.

    @Before
    public void Inicialize(){
        loginPage = new LoginPage(driver);
        loginPage.AcessQazando();
    }
    @Test
    public void loginSucess(){
        loginPage.EnterCredencials("bruno@gmail.com", "123456");
        loginPage.LoginSumitt();
        loginPage.CheckMessage(By.id("swal2-title"), "Login realizado");
    }

    @Test
    public void loginfail(){
        loginPage.EnterCredencials(" ", "123456");
        loginPage.LoginSumitt();
        loginPage.CheckMessage(By.className("invalid_input"), "E-mail inválido.");
    }

    @Test
    public void loginFailPassword(){
        loginPage.EnterCredencials("bob@gmail.com", "");
        loginPage.LoginSumitt();
        loginPage.CheckMessage(By.className("invalid_input"), "Senha inválida.");
    }


}


