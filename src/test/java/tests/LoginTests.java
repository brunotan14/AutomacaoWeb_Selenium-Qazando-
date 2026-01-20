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
        test.info("Teste Login com sucesso");

        test.info("Entrada das credenciais do Usuário");
        loginPage.EnterCredencials("bruno@gmail.com", "123456");

        test.info("Clicando no botao de login.");
        loginPage.LoginSumitt();

        test.info("Validação da mensagem de Login Com sucesso");
        loginPage.CheckMessage(By.id("swal2-title"), "Login realizado");

        test.pass("Login foi realizado");
    }

    @Test
    public void loginfailCredencials(){
        test.info("Teste de Login sem entrada de Credenciais");

        loginPage.EnterCredencials("", "");

        test.info("Clicando no botão de submitt");
        loginPage.LoginSumitt();

        test.info("Validando mensagem de error");
        loginPage.CheckMessage(By.className("invalid_input"), "E-mail inválido.");

        test.pass("Login não realizado.");
    }

    @Test
    public void loginFailPassword(){
        test.info("Teste de login - senha invalida");

        test.info("Entrada das credenciais.");
        loginPage.EnterCredencials("bob@gmail.com", "bru");

        test.info("Clicando no botão de submit");
        loginPage.LoginSumitt();

        test.info("Validação da mensagem de error");
        loginPage.CheckMessage(By.className("invalid_input"), "Senha inválida.");

        test.pass("Login não realizado");
    }


}


