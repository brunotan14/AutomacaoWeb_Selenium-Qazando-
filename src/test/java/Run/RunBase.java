package Run;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;



public class RunBase {
    private static WebDriver driver;

    private RunBase() {}
    // Construtor privado, impedindo que alguém instancie a classe com new RunBase
    // Indica que a classe será usada apenas de forma estática(Padrão singleton).

    public static WebDriver getDriver(){
        String browser = System.getProperty("browser","chrome");
        return getDriver(browser);
    }

    public static WebDriver getDriver(String browser) {

        if (driver !=  null) {
            driver.quit();
        }

        switch (browser) {

            case "chrome":
                driver = new ChromeDriver();
                break;
            case "chrome-ci":
                ChromeOptions chromeOptions = new ChromeOptions(); //Cria um objeto para configurar opções do navegador Chrome antes de iniciar o ChromeDriver.
                chromeOptions.addArguments("--headless=new"); // Headless moderno e estável, antes estava em modo obsoleto desde o chrome 109
                chromeOptions.addArguments("--window-size=1920,1080"); // define o tamanho da janela virtual, evita erros de layout, evita falhas não visiveis
                chromeOptions.addArguments("--disable-gpu"); // desativa o uso da gpu, que em modo headless não é necessária
                chromeOptions.addArguments("--no-sandbox"); // seu uso nao e recomendado em uso local, mas é obrigatório em CI
                chromeOptions.addArguments("--disable-dev-shm-usage"); //Evita o uso de memoria compartilhada
                chromeOptions.addArguments("--remote-allow-origins=*"); // Evita erros de compatibilidadeentre versões do chrome e do chromedriver
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Navegador não encontrado! Passe um navegador existente: chrome, forefox ou edge.");
        }


        return driver;
    }
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
