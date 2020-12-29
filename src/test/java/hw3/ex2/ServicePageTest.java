package hw3.ex2;

import hw3.base.BaseTest;
import org.testng.annotations.Test;

import static hw3.Const.*;

public class ServicePageTest extends BaseTest {

    @Test
    public void presenceElementsOnTheServicePageDisplayed() {

        // 1. Open test site by URL
        openHomePage();

        // 2. Assert Browser title
        assertTitle("Home Page");

        // 3. Perform login
        homePage.login(login, password);

        //4.Assert Username is loggined
        getPageUserName(homePage.getUser(), username);

        //5.Open through the header menu Service -> Different Elements Page
        openDifferentElementsPage(servicePage.getServicePage(), servicePage.getDifferentElementsPageMenuOption());

        //6.Select checkboxes
        selectWaterCheckbox(servicePage.getCheckboxWater());
        selectWindCheckbox(servicePage.getCheckboxWind());

        //7.Select radio
        selectRadio(servicePage.getRadioButtonSelen());

        //8.Select in dropdown
        selectYellowInDropDownMenu(servicePage.getColorsDropDownMenu());

        //9.Assert that for each checkbox there is an individual log row and value is corresponded to the
        //status of checkbox
        assertCheckboxes(servicePage.logWaterCheckbox());
        assertCheckboxes(servicePage.logWindCheckbox());

        //9.Assert that for radio button there is a log row and value is corresponded to the status of radio button
        assertRadio(servicePage.log());

        //9.Assert that for dropdown there is a log row and value is corresponded to the selected value
        assertInDropdown(servicePage.panelWithLogs());
    }
}
