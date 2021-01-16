package hw5.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ElementsFunctionalityOnServicePage extends BaseStep {

    @Given("Page opened")
    public void openHomePage() {
        homePage.openHomePage();
    }

    @Then("Page title is {string} was displayed")
    public void assertTitle(String page) {
        Assert.assertEquals(homePage.getTitle("ROMAN IOVLEV"), page);
    }

    @When("User logged with {string} login and {string} password")
    public void loggIn(String login, String password) {
        homePage.login(login, password);
    }

    @Then("User name is {string} was displayed")
    public void assertUsername(String username) {
        Assert.assertEquals(homePage.getUser().getText(), username);
    }

    @When("User opened through the header menu Service -> Different Elements Page")
    public void openDifferentElementsPage() {
        servicePage.openDifferentElementsPage();
    }

    @And("Checkbox 'Water' elements have been selected")
    public void selectWater() {
        servicePage.selectWaterCheckbox();
    }

    @And("Checkbox 'Wind' elements have been selected")
    public void selectWind() {
        servicePage.selectWindCheckbox();
    }

    @And("Radio 'Selen' element has been selected")
    public void selectRadio() {
        servicePage.selectRadio();
    }

    @And("In dropdown 'Yellow' element has been selected")
    public void selectInDropdown() {
        servicePage.selectYellowInDropDownMenu();
    }

    @Then("{string} log row for water was displayed")
    public void assertWater(String text) {
        for (WebElement checkbox : servicePage.logWaterCheckbox(text)) {
            Assert.assertTrue(checkbox.isDisplayed());
        }
    }

    @And("{string} log row for wind was displayed")
    public void assertWind(String text) {
        for (WebElement checkbox : servicePage.logWindCheckbox(text)) {
            Assert.assertTrue(checkbox.isDisplayed());
        }
    }

    @And("{string} log row for selen was displayed")
    public void assertRadio(String text) {
        for (WebElement logRadio : servicePage.log(text)) {
            Assert.assertTrue(logRadio.isDisplayed());
        }
    }

    @And("{string} log row for yellow color was displayed")
    public void assertInDropdown(String text) {
        for (WebElement logDropdown : servicePage.panelWithLogs(text)) {
            Assert.assertTrue(logDropdown.isDisplayed());
        }
    }
}
