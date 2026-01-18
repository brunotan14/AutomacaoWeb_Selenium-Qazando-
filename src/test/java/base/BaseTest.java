package base;

import Run.RunBase;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    protected WebDriver driver;

    @Before
    public void start() {
        driver = RunBase.getDriver();
        if (!System.getProperty("browser", "").contains("ci")) {
            driver.manage().window().maximize(); // serve para maximizar o navegador selecionado para testes, no modo headless, pode ter erro.
        }

    }

    @After
    public void finish(){
        RunBase.quitDriver();
    }
}
