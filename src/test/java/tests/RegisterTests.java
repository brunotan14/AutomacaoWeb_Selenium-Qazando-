package tests;

import Pages.LoginPage;
import Pages.RegisterPage;
import base.BaseTest;
import org.junit.Before;
import org.junit.Test;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;


public class RegisterTests extends BaseTest {

    private RegisterPage registerPage;
    private Faker faker = new Faker();
    private LoginPage loginPage;
    String user;
    String email;
    String senha;

    @Before
    public void Start(){
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
        registerPage.AcessRegister();
    }

    @Test
    public void RegisterSucess(){
         user = faker.name().fullName();
         email = faker.internet().emailAddress();
         senha = faker.internet().password(6, 10);

        registerPage.FillCredencials(user, email, senha);
        registerPage.RegisterSubmitt();
        loginPage.CheckMessage(By.id("swal2-title"), "Cadastro realizado!");
    }

    @Test
    public void RegisterFail() {
        String nome = "";
        email = faker.name().firstName();
        senha = faker.internet().password(3, 5);

        registerPage.FillCredencials(nome, email, senha);
        registerPage.RegisterSubmitt();
        loginPage.CheckMessage(By.id("errorMessageFirstName"), "O campo nome deve ser prenchido");
    }

    @Test
    public void RegisterFailPassword(){
        user = faker.name().fullName();
        email = faker.internet().emailAddress();
        senha = faker.internet().password(3, 5);

        registerPage.FillCredencials(user, email, senha);
        registerPage.RegisterSubmitt();
        loginPage.CheckMessage(By.id("errorMessageFirstName"), "O campo senha deve ter pelo menos 6 dígitos");

    }
}
