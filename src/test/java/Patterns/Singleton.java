package Patterns;

import org.openqa.selenium.WebDriver;

public class Singleton {

    private static WebDriver driver;
    public static WebDriver getDriver() {
        if (driver == null || driver.toString().contains("null")) {
            driver = BrowserFactory.getInstance();
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
