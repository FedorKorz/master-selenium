package POM.Forms.pages;

import Elements.Button;
import Elements.TextBox;
import POM.Forms.BaseForm;
import Patterns.Singleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsWindowsPage extends BaseForm {
    private final Button alertsButton = new Button(By.xpath("//div[@class='element-list collapse show']//span[text()='Alerts']"));
    private final Button clickMeButton = new Button(By.xpath("//button[@id='alertButton']"));
    private final Button confirmAlertButton = new Button(By.xpath("//button[@id='confirmButton']"));
    private final Button confirmPromptButton = new Button(By.xpath("//button[@id='promtButton']"));
    private final TextBox promptText = new TextBox(By.xpath("//span[@id='promptResult']"));
    private final By alertsFormId = By.id("javascriptAlertsWrapper");
    private final TextBox alertsFrom = new TextBox(alertsFormId);
    private WebDriver driver;

    public AlertsWindowsPage() {
        super(By.xpath("stub"));
        driver = Singleton.getDriver();
    }

    public void clickOnAlerts() {
        alertsButton.navigateToElement();
        wait.waitForElemToAppear(By.xpath("//div[@class='element-list collapse show']//span[text()='Alerts']"));
        alertsButton.clickOnElement();
    }

    public boolean isAlertsPageIsOpened() {
        wait.waitForElemToAppear(alertsFormId);
        return alertsFrom.isElementDisplayed();
    }

    public void clickOnPromptButton() {
        confirmPromptButton.clickOnElement();
    }

    public void clickOnClickMeButton() {
        clickMeButton.clickOnElement();
    }

    public String getTextFromConformationAlert() {
        return getTextFromAlert();
    }

    public void clickConfirmButtonAlert() {
        confirmAlertButton.clickOnElement();
    }

    public String getTextFromPromptAlert() {
        return getTextFromAlert();
    }

    public String getTextAfterPrompt() {
        return promptText.getText();
    }

}
