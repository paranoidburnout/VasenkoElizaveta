package hw2.ex2;

import hw2.base.BaseTest;
import hw2.enums.LoginUser;
import org.testng.annotations.Test;


public class ElementsOnTheServicePage extends BaseTest {

    @Test
    public void presenceElementsOnTheServicePageDisplayed() {

        //1.Open test site by URL
        openURL();

        //2.Assert Browser title
        assertTitle("Home Page");

        //3.Perform login
        performLogin(LoginUser.DEFAULT_USER);

        //4.Assert Username is loggined
        assertUserName(LoginUser.DEFAULT_USER);

        //5.Open through the header menu Service -> Different Elements Page
        openDifferentElementsPage();

        //6.Select checkboxes
        selectWaterCheckbox("Water");
        selectWindCheckbox("Wind");

        //7.Select radio
        selectRadio("Selen");

        //8.Select in dropdown
        selectDropdown("Yellow");

        //9.Assert that for each checkbox there is an individual log row and value is corresponded to the
        //status of checkbox
        assertCheckboxes("Water", true);
        assertCheckboxes("Wind", true);

//        //9.Assert that for radio button there is a log row and value is corresponded to the status of radio button
        assertRadio("metal", "Selen");

//        //9.Assert that for dropdown there is a log row and value is corresponded to the selected value.
        assertInDropdown("Colors", "Yellow");
    }
}
