package Utilities;

import Elements.TextBox;
import Patterns.Singleton;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class BrowserUtility {

    private final TextBox appearedText = new TextBox(By.xpath("//span[@id='confirmResult']"));

    private String randomString = UtilityRandomString.getRandomString();

    private WebDriver driver;

    private static ConditionalWait wait;

    public BrowserUtility() {
        driver = Singleton.getDriver();
        wait = new ConditionalWait();
    }

    public void acceptAlertWindow() {
        acceptAlert();
    }

    public boolean isDialogPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public static void acceptAlert() {
        WebDriver driver = Singleton.getDriver();
        wait.untilAlertIsDisplayed();
        driver.switchTo().alert().accept();
    }

    public String getTextAfterConformationAlert() {
        return appearedText.getText();
    }

    public void acceptConfirmAlert() {
        acceptAlert();
    }
    public void sendKeysToPromptWindow() {
        driver.switchTo().alert().sendKeys(randomString);
    }
    public String getGeneratedString() {
        return randomString;
    }

}
