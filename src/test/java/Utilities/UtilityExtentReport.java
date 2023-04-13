package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class UtilityExtentReport {

    public static ExtentReports getReportObject() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("C:\\Users\\user\\Desktop\\f.korzh-3.2-hotfix\\src\\test\\java\\Output");
        reporter.config().setReportName("DemoQa Test Results");
        reporter.config().setDocumentTitle("Test Results");

        ExtentReports extentReports = new ExtentReports();
        extentReports.attachReporter(reporter);
        return extentReports;
    }
}
