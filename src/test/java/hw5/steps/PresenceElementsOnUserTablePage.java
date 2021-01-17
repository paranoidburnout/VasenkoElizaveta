package hw5.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PresenceElementsOnUserTablePage extends BaseStep {

    @Then("{string} page should be opened")
    public void assertUserTablePage(String page) {
        userTablePage.getTitle(page);
    }

    @And("6 Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void checkNumberTypeDropdown() {
        assertTrue(userTablePage.getNumberTypeDropdowns().stream()
                .allMatch(p -> p.isDisplayed()));
    }

    @And("6 Usernames should be displayed on Users Table on User Table Page")
    public void checkUsernames() {
        assertTrue(userTablePage.getUsernames().stream()
                .allMatch(p -> p.isDisplayed()));
    }

    @And("6 Description texts under images should be displayed on Users Table on User Table Page")
    public void checkDescriptionTextUnderImages() {
        assertTrue(userTablePage.getDescriptionTextsUnderImages().stream()
                .allMatch(p -> p.isDisplayed()));
    }

    @And("6 checkboxes should be displayed on Users Table on User Table Page")
    public void checkCheckboxes() {
        assertTrue(userTablePage.getCheckboxes().stream()
                .allMatch(p -> p.isDisplayed()));
    }

    @And("User table should contain following values:")
    public void checkValues(DataTable data) {
        List<Map<String, String>> table = data.asMaps(String.class, String.class);
        for (int i = 0; i < table.size(); i++) {
            assertEquals(userTablePage.getNumbersValues().get(i), table.get(i).get("Number").trim());
            assertEquals(userTablePage.getUserNamesText().get(i), table.get(i).get("User").trim());
            assertEquals(userTablePage.getDescriptionOfUser().get(i), table.get(i).get("Description").trim());
        }
    }

    @And("Droplist should contain values in column Type for user Roman")
    public void checkDropdownValues(DataTable data) {
        List<Map<String, String>> table = data.asMaps(String.class, String.class);
        for (int i = 0; i < table.size(); i++) {
            assertEquals(userTablePage.getValuesOfDropdown().get(i).getText(),
                    table.get(i).get("Dropdown Values"));
        }
    }
}
