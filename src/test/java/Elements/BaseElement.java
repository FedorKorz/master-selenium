package Elements;

import Patterns.Singleton;
import Utilities.ConditionalWait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public abstract class BaseElement {
    private final WebDriver driver;
    private final ConditionalWait wait;
    private final By locator;
    private Actions action;

    public BaseElement(By locator) {
        this.locator = locator;
        driver = Singleton.getDriver();
        wait = new ConditionalWait();
        action = new Actions(driver);
    }

    public Boolean isElementDisplayed() {
        wait.waitForElemToAppear(locator);
        return driver.findElement(locator).isDisplayed();
    }

    public Boolean isElementDisappeared() {
        return driver.findElement(locator).isDisplayed();
    }

    public void moveToElement() {
        wait.waitForElemToAppear(driver.findElement(locator));
        action.moveToElement(driver.findElement(locator)).build().perform();
    }

    protected void waitForElementAndClick() {
        wait.waitForElemToAppear(driver.findElement(locator));
        moveToElement();

        //driver.findElement(locator).click();

        /* Code works with selenium click and JS click, though sometimes Google Ads overlap webElement */

        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", driver.findElement(locator));
    }

    protected void waitForElementToAppear() {
        wait.waitForElemToAppear(locator);
    }

    public void navigateToElement() {
        action.moveToElement(driver.findElement(locator));
    }

    public void findElement() {
        driver.findElement(locator);
    }

    public String getText() {
        return driver.findElement(locator).getText();
    }

}
