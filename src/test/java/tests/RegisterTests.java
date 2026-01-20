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

        test.info("Iniciando Teste de cadastro com sucesso");

         user = faker.name().fullName();
         email = faker.internet().emailAddress();
         senha = faker.internet().password(6, 10);

        test.info("Preenchendo Dados do usuário");
        registerPage.FillCredencials(user, email, senha);
        registerPage.RegisterSubmitt();

        test.info("Validando mensagem de sucesso");
        loginPage.CheckMessage(By.id("swal2-title"), "Cadastro realizado!");

        test.pass("Cadastro Realizado com sucesso");
    }

    @Test
    public void RegisterFail() {

        test.info("Teste de cadastro sem entrada do nome");

        String nome = "";
        email = faker.name().firstName();
        senha = faker.internet().password(3, 5);

        test.info("Entrada do email e senha");
        registerPage.FillCredencials(nome, email, senha);
        registerPage.RegisterSubmitt();

        test.info("Validando mensagem de error.");
        loginPage.CheckMessage(By.id("errorMessageFirstName"), "O campo nome deve ser prenchido");

        test.pass("Cadastro não realizado");
    }

    @Test
    public void RegisterFailPassword(){

        test.info("Teste de cadastro com senha inferior a 6 dígitos");

        user = faker.name().fullName();
        email = faker.internet().emailAddress();
        senha = faker.internet().password(3, 5);

        test.info("Entrada das credenciais(senha de 5 digitos)");
        registerPage.FillCredencials(user, email, senha);

        test.info("Clicando no botão de submit");
        registerPage.RegisterSubmitt();

        test.info("Validando mensagem de error");
        loginPage.CheckMessage(By.id("errorMessageFirstName"), "O campo senha deve ter pelo menos 6 dígitos");

        test.pass("Status: Cadastro não realizado");
    }

    @Test
    public void RegisterEmailInvalid(){
        test.info("Teste de cadastro com email invalido");

        user = faker.name().fullName();
        email = faker.name().firstName();
        senha = faker.internet().password(6,10);

        test.info("Entrada das credenciais");
        registerPage.FillCredencials(user, email, senha);
        test.info("Clicando no botão de Registrar");
        registerPage.RegisterSubmitt();

        test.info("Validando mensagem de error");
        loginPage.CheckMessage(By.id("errorMessageFirstName"), "O campo e-mail deve ser prenchido corretamente");

        test.pass("Email não validado com sucesso");
    }
}
