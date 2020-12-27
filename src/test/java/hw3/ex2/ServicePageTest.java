package hw3.ex2;

import hw3.GeneralTests;
import hw3.pages.ServicePage;
import org.testng.annotations.Test;

import static hw3.steps.HomePageSteps.*;
import static hw3.steps.ServicePageSteps.*;


import java.io.IOException;

public class ServicePageTest extends GeneralTests {
    protected ServicePage servicePage;

    @Test
    public void presenceElementsOnTheServicePageDisplayed() throws IOException {
        servicePage = new ServicePage(driver);
        // 2. Assert Browser title
        homePage.assertTitle("Home Page");

        // 3. Perform login
        performLogin(homePage);

        //4.Assert Username is loggined
        checkPageUserName(homePage);

        //5.Open through the header menu Service -> Different Elements Page
        openDifferentElementsPage(servicePage);

        //6.Select checkboxes
        selectWaterCheckbox(servicePage);
        selectWindCheckbox(servicePage);

        //7.Select radio
        selectRadio(servicePage);

        //8.Select in dropdown
        servicePage.selectYellowInDropDownMenu();

        //9.Assert that for each checkbox there is an individual log row and value is corresponded to the
        //status of checkbox
        assertCheckboxes(servicePage);

        //9.Assert that for radio button there is a log row and value is corresponded to the status of radio button
        assertRadio(servicePage);

        //9.Assert that for dropdown there is a log row and value is corresponded to the selected value
        assertInDropdown(servicePage);
    }

}
