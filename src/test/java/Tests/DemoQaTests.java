package Tests;

import POM.Forms.pages.AlertsWindowsPage;
import POM.Forms.pages.ElementsPage;
import Utilities.BrowserUtility;
import POM.Forms.pages.FramesNestedPage;
import POM.Forms.pages.FramesOrdinaryPage;
import POM.Forms.Table;
import Utilities.UtilityGetScreenshot;
import Utilities.UtilityParserJSON;
import POM.Forms.BrowserWindows;
import POM.compositeElements.RegistrationForm;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DemoQaTests extends BaseTest {


    @Test(description = ("Test related to #1 Test Case Scenario from a1qa.thinkific"))
    public void testAlerts() {

        log.info("Main page is loaded");
        Assert.assertTrue(mainPage.isMainPageLoaded(), "testAlerts if failed, main page isn't loaded..");
        mainPage.goToNewPage();

        AlertsWindowsPage alertsPage = new AlertsWindowsPage();

        log.info("Text from Alert Window is equal to TestData");
        alertsPage.clickOnAlerts();
        Assert.assertTrue(alertsPage.isAlertsPageIsOpened(), "Alert form hasn't opened");

        log.info("Text from Alert Window is equal to TestData");
        alertsPage.clickOnClickMeButton();
        Assert.assertEquals(alertsPage.getTextFromConformationAlert(), "You clicked a button",
                "testAlerts if failed, getting text from alert is failed.");

        log.info("Accepting Alert Window");
        browserUtility.acceptAlertWindow();
        log.info("Asserting that dialog windows is closed");
        Assert.assertFalse(browserUtility.isDialogPresent(),
                "dialog window is still open");

        log.info("Clicking on Confirmation Alert Button");
        alertsPage.clickConfirmButtonAlert();
        log.info("Text from Alert Window is equal to TestData");
        Assert.assertEquals(alertsPage.getTextFromConformationAlert(), "Do you confirm action?",
                "message from alert isn't equal to Test Data");
        browserUtility.acceptConfirmAlert();

        log.info("Text from Alert Window is equal to TestData");
        Assert.assertEquals(browserUtility.getTextAfterConformationAlert(), "You selected Ok",
                "message from alert isn't equal to Test Data");

        log.info("Clicking on Confirmation Prompt Button");
        alertsPage.clickOnPromptButton();
        log.info("Text from Alert Window is equal to TestData");
        Assert.assertEquals(alertsPage.getTextFromPromptAlert(), "Please enter your name",
                "message from alert isn't equal to Test Data");
        log.info("Sending random string to prompt window");
        browserUtility.sendKeysToPromptWindow();
        BrowserUtility.acceptAlert();
        Assert.assertFalse(browserUtility.isDialogPresent(),
                "dialog windows is still open");
        Assert.assertTrue(alertsPage.getTextAfterPrompt().contains(browserUtility.getGeneratedString()),
                "generated isn't equal to the text on a web page");
    }

    @Test(description = ("Test related to #2 Test Case Scenario from a1qa.thinkific"))
    public void testIFrame() {
        Assert.assertTrue(mainPage.isMainPageLoaded(), "Error in testIFrame: Main Page isn't loaded..");
        mainPage.goToNewPage();

        FramesNestedPage nestedFramesPage = new FramesNestedPage();
        log.info("Page with nested frames is opened");
        nestedFramesPage.openNestedFrames();
        Assert.assertTrue(nestedFramesPage.isFramePageIsLoaded(), "Error in testIFrame: Nested Frames Page isn't loaded..");

        log.info("Parent frames contains TestData");
        Assert.assertEquals(nestedFramesPage.getTextFromParentFrame(), "Parent frame", "Text from Parent Frame isn't equal to Test Data");
        nestedFramesPage.exitFromFrame();
        log.info("Child frames contains TestData");
        Assert.assertEquals(nestedFramesPage.getTextFromChildFrame(), "Child Iframe", "Text from Child Frame isn't equal to Test Data");


        nestedFramesPage.exitFromFrame();
        nestedFramesPage.openOrdinaryFrames();

        FramesOrdinaryPage framesOrdinaryPage = new FramesOrdinaryPage();
        log.info("Data from Frames Page equals Test Data");
        Assert.assertTrue(framesOrdinaryPage.isPageIsLoaded(), "Page With Ordinary Page isn't Open");


        String upperPageText = framesOrdinaryPage.getMessageFromUpperFrame();
        framesOrdinaryPage.exitFromFrame();
        log.info("Text from Parent Frame identical to Child Frame");
        Assert.assertEquals(upperPageText, framesOrdinaryPage.getMessageFromLowerFrame(), "messages from upper and lower frames aren't equal");

    }

    @Test(description = ("Test related to #3 Test Case Scenario from a1qa.thinkific"), dataProvider = "getUsersData")
    public void testTables(JSONObject user) {

        Assert.assertTrue(mainPage.isMainPageLoaded(), "Error in testTables: Main Page isn't loaded..");
        mainPage.goToElementsPage();

        ElementsPage elementsPage = new ElementsPage();
        elementsPage.getElementsPage();
        elementsPage.clickAddButton();

        RegistrationForm registrationForm = new RegistrationForm();
        log.info("Registration page has opened");
        Assert.assertTrue(registrationForm.isRegFromIsPresent(),
                "Registration page hasn't opened");

        elementsPage.setDataToTable(user);
        elementsPage.submitForm();
        Assert.assertTrue(registrationForm.isRegFromIsDisappeared(),
                "Registration page hasn't closed");

        Table table = new Table();

        log.info("Inner Method has started");
        Assert.assertTrue(table.checkIfTableHasEnteredData(user),
                "Error in testTables: Table doesn't have mentioned value..");
        log.info("Saving size of table");
        int sizeOfTable = table.getSizeOfTable();
        table.removeUserFromTable(user);
        Assert.assertNotEquals(sizeOfTable, table.getSizeOfTable(),
                "Error in testTables: Table size hasn't changed value..");
        Assert.assertFalse(table.checkIfTableHasEnteredData(user),
                "Error in testTables: Table still have mentioned value..");
    }

    @DataProvider(name = "getUsersData")
    public Object[][] getDataFromFiles() {
        JSONArray arrUsersJSON = UtilityParserJSON.getTestData("users");
        assert arrUsersJSON != null;
        return new Object[][]{
                {arrUsersJSON.getJSONObject(0)},
                {arrUsersJSON.getJSONObject(1)}
        };
    }

    @Test(description = ("Test related to #4 Test Case Scenario from a1qa.thinkific"))
    public void testHandles() {
        Assert.assertTrue(mainPage.isMainPageLoaded(), "Error in testHandles: Main Page isn't loaded..");
        log.info("New Page is Open");
        mainPage.goToNewPage();
        BrowserWindows browserWindows = new BrowserWindows();
        browserWindows.goToWindowsPage();
        Assert.assertTrue(browserWindows.isWindowsPageLoaded());


        browserWindows.openNewTab();
        browserWindows.focusToNewPage();
        Assert.assertEquals(browserWindows.getTextFromTab(), UtilityParserJSON.getTestData("FirstAlertText"), "New page hasn't opened");
        log.info("Tab is closed");
        browserWindows.closeTab();

        browserWindows.switchToParentPage();
        browserWindows.goToElementsPage();
        log.info("Links Form is opened");
        browserWindows.openLinksForm();
        Assert.assertTrue(browserWindows.isLinksFormIsOpen(), "Links form hasn't opened");

        browserWindows.goToHomePage();
        browserWindows.focusToNewPage();

        Assert.assertTrue(mainPage.isMainPageLoaded(), "Error in testHandles: Main Page isn't loaded..");
        browserWindows.closeTab();
        browserWindows.switchToParentPage();

        Assert.assertTrue(browserWindows.isLinksFormIsOpen(), "Links form hasn't opened");
    }
}


