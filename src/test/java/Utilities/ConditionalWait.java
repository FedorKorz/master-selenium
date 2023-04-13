package Utilities;

import Patterns.Singleton;
import Resources.ConfigurationManager;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConditionalWait {
    private final WebDriverWait wait;


    public ConditionalWait() {
        ConfigurationManager config = ConfigFactory.create(ConfigurationManager.class);
        WebDriver driver = Singleton.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(config.timeout()));
    }

    public void waitForElemToAppear(By findBy) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }

    public void untilWindowsHaveOpened(int numOfWinds) {
        wait.until(ExpectedConditions.numberOfWindowsToBe(numOfWinds));
    }

    public void waitForElemToDisappear(By findBy) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
    }

    public void waitForElemToAppear(WebElement elem) {
        wait.until(ExpectedConditions.visibilityOf(elem));
    }

    public void untilAlertIsDisplayed() {
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void waitUntilAlertIsDisplayed() {
        wait.until(ExpectedConditions.alertIsPresent());
    }

}
