package Elements;

import Patterns.Singleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TableElement extends BaseElement {

    private final WebDriver driver;
    private final By locator;

    public TableElement(By locator) {
        super(locator);
        driver = Singleton.getDriver();
        this.locator = locator;
    }

    public List<WebElement> getList() {
        return driver.findElements(locator);
    }

}
