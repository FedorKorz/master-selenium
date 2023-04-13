package Utilities;

import Tests.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners extends BaseTest implements ITestListener  {

    private final ExtentReports reports = UtilityExtentReport.getReportObject();
    private ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        test = reports.createTest(result.getMethod().getMethodName());
        reports.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test = reports.createTest(result.getMethod().getMethodName());
        test.log(Status.FAIL, "Test has failed " + result.getMethod().getMethodName());
        String filePath = null;
        try {
            filePath = UtilityGetScreenshot.getScreenshot(result.getMethod().getMethodName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
        reports.flush();
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        reports.flush();
    }

}
