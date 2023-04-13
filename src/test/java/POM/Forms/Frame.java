package POM.Forms;

import Patterns.Singleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Frame extends BaseForm {
    private final WebDriver driver;
    private final By locator;

    public Frame(By locator) {
        super(locator);
        driver = Singleton.getDriver();
        this.locator = locator;
    }

    public void switchToFrame() {
        driver.switchTo().frame(driver.findElement(locator));
    }

}
