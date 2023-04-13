package POM.Forms;

import Elements.Button;
import Elements.TextBox;
import POM.compositeElements.LeftPanel;
import Patterns.Singleton;
import Resources.ConfigurationManager;
import Utilities.UtilityConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

public class BrowserWindows extends BaseForm {
    private static WebDriver driver;
    static private String parentPage = "";
    private final LeftPanel leftPanel = new LeftPanel();
    private final By windowsForm = By.xpath("//div[@class='element-list collapse show']//li[@id='item-0' and //span[contains(text(), 'Browser Windows')]]");
    private final Button gotoWindowsPage = new Button(windowsForm);
    private final Button newTab = new Button(By.xpath("//button[@id='tabButton']"));
    private final TextBox headingFromNewPage = new TextBox(By.id("sampleHeading"));
    private final TextBox linkForm = new TextBox(By.id("linkWrapper"));
    private final Button homeLink = new Button(By.id("simpleLink"));
    private static ConfigurationManager config;

    public BrowserWindows() {
        super(By.xpath("stub"));
        driver = Singleton.getDriver();
        config = UtilityConfig.getConfig();
    }

    public void goToWindowsPage() {
        wait.waitForElemToAppear(driver.findElement(windowsForm));
        gotoWindowsPage.clickOnElement();
    }

    public boolean isWindowsPageLoaded() {
        return newTab.isElementDisplayed();
    }

    public void openNewTab() {
        newTab.clickOnElement();
    }

    public void focusToNewPage() {
        Set<String> windowHandlersSet = driver.getWindowHandles();
        parentPage = "";

        Iterator<String> iterator = driver.getWindowHandles().iterator();
        parentPage = iterator.next();

        if (driver.getWindowHandles().size() == windowHandlersSet.size()) {
            wait.untilWindowsHaveOpened(config.numOfMaxWindows());
            driver.switchTo().window(iterator.next());
        }
    }

    public void switchToParentPage() {
        driver.switchTo().window(parentPage);
    }

    public String getTextFromTab() {
        return headingFromNewPage.getTextFromLabel();
    }

    public void closeTab() {
        driver.close();
    }

    public void goToElementsPage() {
        leftPanel.clickOnRealElementsButton();
    }

    public void openLinksForm() {
        leftPanel.clickOnLinks();
    }

    public void goToHomePage() {
        homeLink.clickOnElement();
    }

    public boolean isLinksFormIsOpen() {
        return linkForm.isElementDisplayed();
    }

}
