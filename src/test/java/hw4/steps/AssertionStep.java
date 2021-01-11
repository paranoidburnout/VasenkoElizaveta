package hw4.steps;

import hw4.Const;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AssertionStep extends BaseStep {

    public AssertionStep(WebDriver driver) {
        super(driver);
    }

    @Step("Assert Browser title")
    public void assertTitle() {
        Assert.assertEquals(homePage.getTitle(), "Home Page");
    }

    @Step("Assert Username is loggined")
    public void assertUsername() {
        Assert.assertEquals(homePage.getUser().getText(), Const.username);
    }

    @Step("Assert that there are 4 items on the header section are displayed")
    public void assertItemsOnTheHeaderAreDisplayed() {
        Assert.assertTrue(homePage.getItemsOnTheHeader().isDisplayed());
    }

    @Step("Assert that there are 4 items on the header section have proper texts")
    public void assertItemsOnTheHeaderHaveTexts() {
        Assert.assertEquals(homePage.getHomeMenuTab().getText(), "HOME");
        Assert.assertEquals(homePage.getContactFormMenuTab().getText(), "CONTACT FORM");
        Assert.assertEquals(homePage.getServiceMenuTab().getText(), "SERVICE");
        Assert.assertEquals(homePage.getMetalColorsMenuTab().getText(), "METALS & COLORS");
    }

    @Step("Assert that there are 4 images on the Index Page and they are displayed")
    public void verifyImagesOnTheHomePageAreDisplayed() {
        Assert.assertEquals(homePage.getImages().size(), 4);
        for (WebElement element : homePage.getImages()) {
            Assert.assertTrue(element.isDisplayed());
        }
    }

    @Step("Assert that there are 4 texts on the Index Page under icons and they have proper text")
    public void assertImagesOnTheHeaderHaveTexts() {
        assertEquals(homePage.getTexts().size(), 4);
        for (WebElement text : homePage.getTexts()) {
            assertTrue(text.isDisplayed());
        }
    }

    @Step("Assert that there is the iframe with “Frame Button” exist")
    public void assertFrameExist() {
        Assert.assertTrue(homePage.getFrame().isDisplayed());
    }

    @Step("Check that there is “Frame Button” in the iframe")
    public void assertFrameButtonExist() {
        Assert.assertTrue(homePage.getButtonFrame().isDisplayed());
    }

    @Step("Assert that there is Left Section")
    public void verifyLeftElementsAreDisplayed() {
        Assert.assertTrue(homePage.getItemsOnTheLeftSection().isDisplayed());
    }

    @Step("Assert that for each checkbox there is an individual log row " +
            "and value is corresponded to the status of checkbox")
    public void assertCheckboxes() {
        for (WebElement checkbox : servicePage.logWaterCheckbox()) {
            Assert.assertTrue(checkbox.isDisplayed());
        }
        for (WebElement checkbox : servicePage.logWindCheckbox()) {
            Assert.assertTrue(checkbox.isDisplayed());
        }
    }

    @Step("Assert that for radio button there is a log row and value is corresponded to the status of radio button")
    public void assertRadio() {
        for (WebElement logRadio : servicePage.log()) {
            Assert.assertTrue(logRadio.isDisplayed());
        }
    }

    @Step("Assert that for dropdown there is a log row and value is corresponded to the selected value")
    public void assertInDropdown() {
        for (WebElement logDropdown : servicePage.panelWithLogs()) {
            Assert.assertTrue(logDropdown.isDisplayed());
        }
    }
}
