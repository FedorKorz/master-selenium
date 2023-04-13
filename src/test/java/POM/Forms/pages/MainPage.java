package POM.Forms.pages;

import Elements.Button;
import POM.Forms.BaseForm;
import org.openqa.selenium.By;

public class MainPage extends BaseForm {

    private final String alertsPageLink = "//div[@class='card-body']//h5[contains(.,'Alerts,')]";
    private final String elementsPageLink = "//div[@class='card-body']//h5[contains(.,'Elements')]";
    private final Button alertsFrameWindowsBtn = new Button(By.xpath(alertsPageLink));
    private final Button elementsBtn = new Button(By.xpath(elementsPageLink));

    public MainPage() {
        super(By.xpath("//div[@class='home-banner']"));
    }

    public boolean isMainPageLoaded() {
        return isPageIsLoaded();
    }

    public void goToNewPage() {
        alertsFrameWindowsBtn.clickOnElement();
    }

    public void goToElementsPage() {
        elementsBtn.clickOnElement();
    }
}
