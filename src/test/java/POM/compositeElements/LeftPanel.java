package POM.compositeElements;

import Elements.Button;
import POM.Forms.BaseForm;
import org.openqa.selenium.By;

public class LeftPanel extends BaseForm {

    private final Button webTablesButton = new Button(By.xpath("//div[contains(@class,'element-group')]//span[contains(text(), 'Tables')]"));
    private final Button elementsTable = new Button(By.xpath("//div[contains(@class,'header-wrapper')]//div[contains(text(), 'Elements')]"));
    private final Button getLinksButton = new Button(By.xpath("//li[@id='item-5']//span[(contains(text(),'Links'))]"));

    public LeftPanel() {
        super(By.xpath("stub"));
    }

    public void clickOnWebTablesButton() {
        webTablesButton.clickOnElement();
    }

    public void clickOnRealElementsButton() {
        elementsTable.clickOnElement();
    }

    public void clickOnLinks() {
        getLinksButton.clickOnElement();
    }
}
