package base;

import Run.RunBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;
import report.ExportReport;


public class BaseTest {

    protected ExtentReports extent; //controla o relatorio
    protected WebDriver driver; //controla  o driver
    protected ExtentTest test; // representa um teste especifico no relatorio

    @Rule // regra do JUnit para nome do teste(Captura o nome do metodo do teste)
    public TestName testName = new TestName();


        @Before
    public void start() {
        driver = RunBase.getDriver();
        if (!System.getProperty("browser", "").contains("ci")) {
            driver.manage().window().maximize(); // serve para maximizar o navegador selecionado para testes, no modo headless, pode ter erro.
        }

        //Relatório
        extent = ExportReport.getInstance(); //obtem a instancia unica do relatorio, garantindo que todos os testes escrevam no mesmo html
        test = extent.createTest(testName.getMethodName()); // cria uma entrada no relaotiro pra cada teste especifico

    }

    @After
    public void finish(){
        RunBase.quitDriver();

        //gravação do relátorio:
        //sem o flush, o relatorio nao e salvo ou fica incompleto
        extent.flush();

    }
}
