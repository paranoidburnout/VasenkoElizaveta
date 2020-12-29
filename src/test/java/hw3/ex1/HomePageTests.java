package hw3.ex1;

import hw3.base.BaseTest;
import org.testng.annotations.Test;

import static hw3.Const.*;

public class HomePageTests extends BaseTest {

    protected String mainWindowHandle;

    @Test
    public void thePresenceOfMainElementsOnTheHomePage() {

        // 1. Open test site by URL
        openHomePage();

        // 2. Assert Browser title
        assertTitle("Home Page");

        // 3. Perform login
        homePage.login(login, password);

        //4.Assert Username is loggined
        getPageUserName(homePage.getUser(), username);

        // 5. Assert that there are 4 items on the header section are displayed and they have proper texts
        checkHeaderSection(homePage.getItemsOnTheHeader(), homePage.getHomeMenuTab(),
                homePage.getContactFormMenuTab(), homePage.getServiceMenuTab(), homePage.getMetalColorsMenuTab());

        // 6. Assert that there are 4 images on the Index Page and they are displayed
        checkImages(homePage.getImages());

        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        checkTextsUnderImages(homePage.getTexts());

        //8.Assert that there is the iframe with “Frame Button” exist
        assertFrameButton(homePage.getFrame());

        //9.Switch to the iframe and check that there is “Frame Button” in the iframe
        mainWindowHandle = driver.getWindowHandle();
        driver.switchTo().frame(homePage.getFrame());
        frameButtonExists(homePage.getButtonFrame());

        // 10. Switch to original window back
        driver.switchTo().window(mainWindowHandle);

        // 11. Assert that there is Left Section
        checkLeftSection(homePage.getItemsOnTheLeftSection());
    }
}
