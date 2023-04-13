package POM.Forms;

import Patterns.Singleton;
import Resources.ConfigurationManager;
import Utilities.ConditionalWait;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public abstract class BaseForm {

    private final WebDriver driver;
    private final By locator;
    private final Actions action;
    public ConfigurationManager config;
    protected ConditionalWait wait;

    protected BaseForm(By locator) {
        this.locator = locator;
        driver = Singleton.getDriver();
        action = new Actions(driver);
        wait = new ConditionalWait();
        config = ConfigFactory.create(ConfigurationManager.class);
    }

    public boolean isPageIsLoaded() {
        return driver.findElement(locator).isDisplayed();
    }

    public void exitFromFrame() {
        driver.switchTo().defaultContent();
    }

    public String getTextFromAlert() {
        return driver.switchTo().alert().getText();
    }

}
