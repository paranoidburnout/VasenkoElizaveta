package hw5.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static hw5.Const.*;

public class ElementsFunctionalityOnUserTable extends BaseStep {

    @Given("I open JDI GitHub site")
    public void openHomePage() {
        homePage.openHomePage();
    }

    @And("I login as user {string}")
    public void loggIn(String username) {
        homePage.login(login, password);
        Assert.assertEquals(homePage.getUser().getText(), username);
    }

    @And("I click on \"Service\" button in Header")
    public void clickServiceHeader() {
        servicePage.getServicePage().click();
    }

    @And("I click on \"User Table\" button in Service dropdown")
    public void clickUserTableButton() {
        userTablePage.openUserTable();
    }

    @When("I select 'vip' checkbox for \"Sergey Ivan\"")
    public void selectVipCheckbox() {
        userTablePage.selectVipCheckbox();
    }

    @Then("1 log row has {string} text in log section")
    public void logRowHasTextInLogSection(String text) {
        for (WebElement logVipCheckbox : userTablePage.logRowBack(text)) {
            Assert.assertTrue(logVipCheckbox.isDisplayed());
        }
    }
}
