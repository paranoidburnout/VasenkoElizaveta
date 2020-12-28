package hw3.ex1;

import hw3.GeneralTests;
import hw3.pages.HomePage;
import org.testng.annotations.Test;

import static hw3.Const.*;


public class HomePageTests extends GeneralTests {

    protected String mainWindowHandle;

    @Test
    public void thePresenceOfMainElementsOnTheHomePage() {

        homePage = new HomePage(driver);

        // 2. Assert Browser title
        homePage.assertTitle("Home Page");

        // 3. Perform login
        homePage.login(login, password);

        //4.Assert Username is loggined
        homePage.getPageUserName(username);

        // 5. Assert that there are 4 items on the header section are displayed and they have proper texts
        homePage.checkHeaderSection(homePage.getItemsOnTheHeader(), homePage.getHomeMenuTab(),
                homePage.getContactFormMenuTab(), homePage.getServiceMenuTab(), homePage.getMetalColorsMenuTab());

        // 6. Assert that there are 4 images on the Index Page and they are displayed
        homePage.checkImages(homePage.getImages());

        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        homePage.checkTextsUnderImages(homePage.getTexts());

        //8.Assert that there is the iframe with “Frame Button” exist
        homePage.assertFrameButton(homePage.getFrame());

        //9.Switch to the iframe and check that there is “Frame Button” in the iframe
        mainWindowHandle = driver.getWindowHandle();
        driver.switchTo().frame(homePage.getFrame());
        homePage.frameButtonExists(homePage.getButtonFrame());

        // 10. Switch to original window back
        driver.switchTo().window(mainWindowHandle);

        // 11. Assert that there is Left Section
        homePage.checkLeftSection(homePage.getItemsOnTheLeftSection());

    }
}
