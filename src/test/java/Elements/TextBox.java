package Elements;

import Patterns.Singleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextBox extends BaseElement {
    private WebDriver driver;
    private By locator;

    public TextBox(By locator) {
        super(locator);
        driver = Singleton.getDriver();
        this.locator = locator;
    }

    public String getTextFromLabel() {
        return driver.findElement(locator).getText();
    }

    public void setText(String text) {
        waitForElementToAppear();
        driver.findElement(locator).sendKeys(text);
    }

    public void waitTextBoxToAppear() {
        waitForElementToAppear();
    }

}
