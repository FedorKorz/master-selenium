package POM.Forms;

import Elements.TableElement;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Table extends BaseForm {
    private final TableElement columnWithDeleteButtons = new TableElement(By.xpath("//span[contains(@id, 'delete')]"));
    private final TableElement columnsNew = new TableElement(By.xpath("(//div[@role='rowgroup'])"));
    public Table() {
        super(By.xpath("stub"));
    }

    public Boolean checkIfTableHasEnteredData(JSONObject user) {
        return getTable().stream().anyMatch(s -> s.contains(user.getString("First Name")));
    }

    public List<String> getTable() {
        List<String> tableInListFormat = new ArrayList<>();

        for (WebElement element : columnsNew.getList()) {
            if (!element.getText().contains(" ")) {
                tableInListFormat.add(Arrays.toString(element.getText().split("\n")));
            }
        }
        return tableInListFormat;
    }

    public void removeUserFromTable(JSONObject user) {
        List<String> list = getTable();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).contains(user.getString("First Name"))) {
                columnWithDeleteButtons.getList().get(i).click();
                break;
            }
        }
    }

    public int getSizeOfTable() {
        return getTable().size();
    }

}