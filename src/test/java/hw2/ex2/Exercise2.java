package hw2.ex2;

import hw2.base.BaseTest;
import org.testng.annotations.Test;

public class Exercise2 extends BaseTest {
    @Test
    public void testingExercise_2() {
        //1.Open test site by URL
        openURL();

        //2.Assert Browser title
        assertTitle();

        //3.Perform login
        performLogin();

        //4.Assert Username is loggined
        assertUserName();

        //5.Open through the header menu Service -> Different Elements Page
        openDifferentElementsPage();

        //6.Select checkboxes
        selectWaterCheckbox();
        selectWindCheckbox();

        //7.Select radio
        selectRadio();

        //8.Select in dropdown
        selectDropdown();

        //9.Assert that for each checkbox there is an individual log row and value is corresponded to the
        //status of checkbox
        assertCheckboxes();

        //9.Assert that for radio button there is a log row and value is corresponded to the status of radio button
        assertRadio();

        //9.Assert that for dropdown there is a log row and value is corresponded to the selected value.
        assertInDropdown();
    }
}
