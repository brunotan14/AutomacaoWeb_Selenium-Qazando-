package Run;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;


public class RunBase {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private RunBase() {}

    public static WebDriver getDriver() {
        String browser = System.getProperty("browser", "chrome");
        return getDriver(browser);
    }

    public static WebDriver getDriver(String browser) {

        if (driver.get() == null) {

            switch (browser) {

                case "chrome":
                    driver.set(new ChromeDriver());
                    break;

                case "chrome-ci":
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments(
                            "--headless=new",
                            "--window-size=1920,1080",
                            "--disable-dev-shm-usage",
                            "--remote-allow-origins=*"
                    );
                    driver.set(new ChromeDriver(options));
                    break;

                case "firefox":
                    driver.set(new FirefoxDriver());
                    break;

                case "safari":
                    driver.set(new SafariDriver());
                    break;

                case "edge":
                    driver.set(new EdgeDriver());
                    break;

                default:
                    throw new IllegalArgumentException(
                            "Navegador não encontrado! Use: chrome, chrome-ci, firefox, safari ou edge."
                    );
            }
        }

        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
