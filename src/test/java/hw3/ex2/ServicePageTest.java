package hw3.ex2;

import hw3.GeneralTests;
import hw3.pages.ServicePage;
import org.testng.annotations.Test;

import static hw3.Const.*;


public class ServicePageTest extends GeneralTests {

    protected ServicePage servicePage;

    @Test
    public void presenceElementsOnTheServicePageDisplayed() {

        servicePage = new ServicePage(driver);

        // 2. Assert Browser title
        homePage.assertTitle("Home Page");

        // 3. Perform login
        homePage.login(login, password);

        //4.Assert Username is loggined
        homePage.getPageUserName(username);

        //5.Open through the header menu Service -> Different Elements Page
        servicePage.openDifferentElementsPage(servicePage.getServicePage(),servicePage.getDifferentElementsPageMenuOption());

        //6.Select checkboxes
        servicePage.selectWaterCheckbox(servicePage.getCheckboxWater());
        servicePage.selectWindCheckbox(servicePage.getCheckboxWind());

        //7.Select radio
        servicePage.selectRadio(servicePage.getRadioButtonSelen());

        //8.Select in dropdown
        servicePage.selectYellowInDropDownMenu(servicePage.getColorsDropDownMenu());

        //9.Assert that for each checkbox there is an individual log row and value is corresponded to the
        //status of checkbox
        servicePage.assertCheckboxes(servicePage.logWaterCheckbox());
        servicePage.assertCheckboxes(servicePage.logWindCheckbox());

        //9.Assert that for radio button there is a log row and value is corresponded to the status of radio button
        servicePage.assertRadio(servicePage.log());

        //9.Assert that for dropdown there is a log row and value is corresponded to the selected value
        servicePage.assertInDropdown(servicePage.panelWithLogs());
    }
}
