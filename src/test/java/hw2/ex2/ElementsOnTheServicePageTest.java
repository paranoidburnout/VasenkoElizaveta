package hw2.ex2;

import hw2.base.BaseTest;
import hw2.enums.LoginUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class ElementsOnTheServicePageTest extends BaseTest {

    @Test
    public void presenceElementsOnTheServicePageDisplayed() {

        //1.Open test site by URL
        openHomePage();

        //2.Assert Browser title
        assertTitle("Home Page");

        //3.Perform login
        performLogin(LoginUser.DEFAULT_USER);

        //4.Assert Username is loggined
        assertUserName(LoginUser.DEFAULT_USER);

        //5.Open through the header menu Service -> Different Elements Page
        openPageFromLeftMenu("Different elements");

        //6.Select checkboxes
        selectWaterCheckbox("Water");
        selectWindCheckbox("Wind");

        //7.Select radio
        selectRadio("Selen");

        //8.Select in dropdown
        selectDropdown("Yellow");

        //9.Assert that for each checkbox there is an individual log row and value is corresponded to the
        //status of checkbox
        List<WebElement> logCheckbox = getLogRowsByKeyWord("Water: condition changed to true");
        assertCheckboxes(logCheckbox);
        logCheckbox = getLogRowsByKeyWord("Wind: condition changed to true");
        assertCheckboxes(logCheckbox);

//        //9.Assert that for radio button there is a log row and value is corresponded to the status of radio button
        List<WebElement> log = getLogRowsByKeyWord("metal: value changed to  Selen");
        assertRadio(log);

//        //9.Assert that for dropdown there is a log row and value is corresponded to the selected value
        List<WebElement> panelWithLogs = getLogRowsByKeyWord("Colors: value changed to Yellow");
        assertInDropdown(panelWithLogs);
    }

    private List<WebElement> getLogRowsByKeyWord(String word) {
        driver.findElements(By.xpath("//li[contains(text(),'" + word + "')]"));

        return driver.findElements(By.xpath("//li[contains(text(),'" + word + "')]"));
    }
}
