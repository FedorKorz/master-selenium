package POM.Forms.pages;

import Elements.Button;
import POM.Forms.Frame;
import Elements.TextBox;
import POM.Forms.BaseForm;
import org.openqa.selenium.By;


public class FramesNestedPage extends BaseForm {

    private final Button openNestedFrames = new Button(By.xpath("//ul[@class='menu-list']//span[contains(.,'Nested Frames')]"));
    private final Frame frameWrapper = new Frame(By.id("frame1"));
    private final Frame childFrame = new Frame(By.xpath(".//iframe[@srcdoc='<p>Child Iframe</p>']"));
    private final TextBox textFromParentFrame = new TextBox(By.tagName("body"));
    private final TextBox elemInChildFrame = new TextBox(By.tagName("p"));
    private final Button openFramesButton = new Button(By.xpath("//div[@class='element-list collapse show']//li[@id='item-2' and span[contains(.,'Frames')]]"));
    private final By textFromFrame = By.tagName("body");

    public FramesNestedPage() {
        super(By.xpath("//div[@class='row']"));
    }

    public Boolean isFramePageIsLoaded() {
        return isPageIsLoaded();
    }

    public void openOrdinaryFrames() {
        openFramesButton.clickOnElement();
    }

    public void openNestedFrames() {
        openNestedFrames.clickOnElement();
    }

    public String getTextFromParentFrame() {
        frameWrapper.switchToFrame();
        wait.waitForElemToAppear(textFromFrame);
        textFromParentFrame.findElement();
        return textFromParentFrame.getTextFromLabel();
    }

    public String getTextFromChildFrame() {
        frameWrapper.switchToFrame();
        childFrame.switchToFrame();
        return elemInChildFrame.getTextFromLabel();
    }
}
