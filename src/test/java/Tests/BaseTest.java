package Tests;

import POM.Forms.pages.MainPage;
import Patterns.Singleton;
import Resources.ConfigurationManager;
import Utilities.BrowserUtility;
import Utilities.LoggerObject;
import Utilities.UtilityZoomWindow;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


public class BaseTest {
    private static WebDriver driver = null;
    public MainPage mainPage;
    public BrowserUtility browserUtility;
    public Logger log;
    ExtentReports extentReports;

    @BeforeSuite
    public void setUp() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("src/test/java/Resources");
        reporter.config().setReportName("Web Automation Course from Udemy");
        reporter.config().setDocumentTitle("Test Results");
        extentReports = new ExtentReports();
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Tester", "Fiodor Korzh");
    }

    @BeforeMethod
    public void BeforeTestMethod() {
        ConfigurationManager config = ConfigFactory.create(ConfigurationManager.class);
        log = LoggerObject.getLogger();
        log.info("Test has started");
        driver = Singleton.getDriver();
        driver.get(config.url());
        mainPage = new MainPage();
        browserUtility = new BrowserUtility();
        UtilityZoomWindow.ZoomOut();
    }

    @AfterMethod
    public void afterTestMethod() {
        Singleton.quitDriver();
    }
}
