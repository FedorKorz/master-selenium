package POM.Forms.pages;

import POM.Forms.Frame;
import Elements.TextBox;
import POM.Forms.BaseForm;
import org.openqa.selenium.By;

public class FramesOrdinaryPage extends BaseForm {

    private final Frame upperFrame = new Frame(By.id("frame1"));
    private final Frame lowerFrame = new Frame(By.id("frame2"));
    private final TextBox elementFromFrame = new TextBox(By.id("sampleHeading"));


    public FramesOrdinaryPage() {
        super(By.id("framesWrapper"));
    }

    public String getMessageFromUpperFrame() {
        upperFrame.switchToFrame();
        elementFromFrame.findElement();
        return elementFromFrame.getText();
    }

    public String getMessageFromLowerFrame() {
        lowerFrame.switchToFrame();
        elementFromFrame.waitTextBoxToAppear();
        elementFromFrame.findElement();
        return elementFromFrame.getText();
    }

}
