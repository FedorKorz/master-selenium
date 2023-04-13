package POM.Forms.pages;

import Elements.Button;
import Models.UserModel;
import POM.Forms.BaseForm;
import POM.compositeElements.LeftPanel;
import POM.compositeElements.RegistrationForm;
import org.json.JSONObject;
import org.openqa.selenium.By;

public class ElementsPage extends BaseForm {

    private final LeftPanel leftPanel = new LeftPanel();
    private final RegistrationForm registrationForm = new RegistrationForm();
    private final Button addButton = new Button(By.id("addNewRecordButton"));

    public ElementsPage() {
        super(By.xpath("//div[@class='row']"));
    }

    public void getElementsPage() {
        leftPanel.clickOnWebTablesButton();
    }

    public void clickAddButton() {
        addButton.clickOnElement();
    }

    public void setDataToTable(JSONObject user) {
        registrationForm.fillRegistrationForm(new UserModel(
                user.getString("First Name"),
                user.getString("Last Name"),
                user.getInt("Age"),
                user.getString("Email"),
                user.getInt("Salary"),
                user.getString("Department")
        ));
    }

    public void submitForm() {
        registrationForm.clickSubmitButton();
    }

}