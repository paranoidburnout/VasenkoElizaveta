package hw3.ex1;

import hw3.GeneralTests;
import hw3.pages.HomePage;
import org.testng.annotations.Test;

import java.io.IOException;

import static hw3.steps.HomePageSteps.*;

public class HomePageTests extends GeneralTests {

    protected String mainWindowHandle;

    @Test
    public void thePresenceOfMainElementsOnTheHomePage() throws IOException {
        homePage = new HomePage(driver);
        // 2. Assert Browser title
        homePage.assertTitle("Home Page");

        // 3. Perform login
        performLogin(homePage);

        //4.Assert Username is loggined
        checkPageUserName(homePage);

        // 5. Assert that there are 4 items on the header section are displayed and they have proper texts
        checkHeaderSection(homePage);

        // 6. Assert that there are 4 images on the Index Page and they are displayed
        checkImages(homePage);

        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        checkTextsUnderImages(homePage);

        //8.Assert that there is the iframe with “Frame Button” exist
        assertFrameButton(homePage);

        //9.Switch to the iframe and check that there is “Frame Button” in the iframe
        mainWindowHandle = driver.getWindowHandle();
        driver.switchTo().frame(homePage.getFrame());
        frameButtonExists(homePage);

        // 10. Switch to original window back
        driver.switchTo().window(mainWindowHandle);

        // 11. Assert that there is Left Section
        checkLeftSection(homePage);

    }
}
