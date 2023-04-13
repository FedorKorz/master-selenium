package Patterns;

import Resources.ConfigurationManager;
import Utilities.UtilityConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserFactory {

    private static WebDriver driver = null;
    private static ConfigurationManager config = UtilityConfig.getConfig();

    public static WebDriver getInstance() {

        Logger log = LogManager.getLogger();

        String browserName = System.getProperty("browser") != null ? System.getProperty("browser") : config.browser().toUpperCase();

            switch (browserName.toUpperCase()) {
                case "CHROME" -> {
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments(config.chromeOptions());
                    driver = new ChromeDriver(options);
                    driver.manage().window().maximize();
                }
                case "FIREFOX" -> {
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions options = new FirefoxOptions();
                    options.addArguments();
                    driver = new FirefoxDriver(options);
                }
                case "EDGE" -> {
                    WebDriverManager.edgedriver().setup();
                    EdgeOptions options = new EdgeOptions();
                    options.addArguments();
                    driver = new EdgeDriver(options);
                }
                default -> {
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments(config.chromeOptions());
                    driver = new ChromeDriver(options);
                    log.info("Specify browser for Testing");
                }
            }
        return driver;
    }
}
