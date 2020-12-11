package hw2.ex1;

import hw2.base.BaseTest;
import org.testng.annotations.Test;

public class Exercise1 extends BaseTest {

    @Test
    public void testingExercise_1() {
        //1.Open test site by URL
        openURL();

        //2.Assert Browser title
        assertTitle();

        //3.Perform login
        performLogin();

        //4.Assert Username is loggined
        assertUserName();

        //5.Assert that there are 4 items on the header section are displayed and they have proper texts
        assertItemsOnTheHeaderSection();

        //6.Assert that there are 4 images on the Index Page and they are displayed
        checkImagesExistence();

        //7.Assert that there are 4 texts on the Index Page under icons and they have proper text
        checkTextBelowIcons();

        //8.Assert that there is the iframe with “Frame Button” exist
        assertFrameButton();

        //9.Switch to the iframe and check that there is “Frame Button” in the iframe
        switchToTheFrameAndCheck();

        //10.Switch to original window back
        switchToOriginalWindowBack();

        //11.Assert that there are 5 items in the Left Section are displayed and they have proper text
        assertItemsOnTheLeftSection();
    }
}
