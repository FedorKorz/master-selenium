package Utilities;

import Patterns.Singleton;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class UtilityGetScreenshot {

    public static String getScreenshot(String testCaseName) {
        String fileName = "C:/Users/user/Desktop/f.korzh-3.2-hotfix/src/test/java/Output/" + testCaseName + ".png";
        System.out.println("UserDir " + System.getProperty("user.dir"));

        WebDriver driver = Singleton.getDriver();
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(fileName);
        try {
            FileUtils.copyFile(source, file);
            return fileName;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
