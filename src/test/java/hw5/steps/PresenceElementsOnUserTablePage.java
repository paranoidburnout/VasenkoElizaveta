package hw5.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class PresenceElementsOnUserTablePage extends BaseStep {

    @Then("{string} page should be opened")
    public void assertUserTablePage(String page) {
        userTablePage.getTitle(page);
    }

    @And("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void checkNumberTypeDropdown(int expectedAmount) {

    }

    @And("{int} Usernames should be displayed on Users Table on User Table Page")
    public void checkUsernames(int expectedAmount) {

    }

    @And("{int} Description texts under images should be displayed on Users Table on User Table Page")
    public void checkDescriptionTextUnderImages(int expectedAmount) {

    }

    @And("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void checkCheckboxes(int expectedAmount) {

    }

    @And("User table should contain following values:")
    public void checkValues() {

    }

    @And("Droplist should contain values in column Type for user Roman")
    public void checkDropdownValues() {

    }
}
