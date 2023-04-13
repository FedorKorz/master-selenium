package POM.compositeElements;

import Elements.Button;
import Elements.TextBox;
import Models.UserModel;
import POM.Forms.BaseForm;
import Patterns.Singleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class RegistrationForm extends BaseForm {

    private final String firstNameLoc = "firstName";
    private final String lastNameLoc = "lastName";
    private final String userEmailLoc = "userEmail";
    private final String ageLoc = "age";
    private final String salaryLoc = "salary";
    private final String departmentLoc = "department";
    private final String submitBtnLoc = "submit";
    private final TextBox firstName = new TextBox(By.id(firstNameLoc));
    private final TextBox lastName = new TextBox(By.id(lastNameLoc));
    private final TextBox email = new TextBox(By.id(userEmailLoc));
    private final TextBox age = new TextBox(By.id(ageLoc));
    private final TextBox salary = new TextBox(By.id(salaryLoc));
    private final TextBox department = new TextBox(By.id(departmentLoc));
    private final Button submitButton = new Button(By.id(submitBtnLoc));
    private final TextBox registrationPage = new TextBox(By.id("registration-form-modal"));
    private final By regFormId = By.id("registration-form-modal");
    WebDriver driver;

    public RegistrationForm() {
        super(By.xpath("//div[@class='modal-content']"));
        driver = Singleton.getDriver();
    }

    public boolean isRegFromIsPresent() {
        try {
            wait.waitForElemToAppear(regFormId);
            return registrationPage.isElementDisplayed();
        } catch (Exception ex) {
            return true;
        }
    }

    public boolean isRegFromIsDisappeared() {
        try {
            wait.waitForElemToDisappear(regFormId);
            return registrationPage.isElementDisplayed();
        } catch (Exception e) {
            return true;
        }
    }

    public void fillRegistrationForm(UserModel user) {
        setUserName(user);
        setUserLastName(user);
        setUserEmail(user);
        setUserAge(user);
        setUserSalary(user);
        setUserDepartment(user);
    }

    private void setUserName(UserModel user) {
        firstName.setText(user.firstName());
    }

    private void setUserLastName(UserModel user) {
        lastName.setText(user.lastName());
    }

    private void setUserEmail(UserModel user) {
        email.setText(user.Email());
    }

    private void setUserAge(UserModel user) {
        age.setText(String.valueOf(user.age()));
    }

    private void setUserSalary(UserModel user) {
        salary.setText(String.valueOf(user.salary()));
    }

    private void setUserDepartment(UserModel user) {
        department.setText(user.department());
    }

    public void clickSubmitButton() {
        submitButton.clickOnElement();
    }

}