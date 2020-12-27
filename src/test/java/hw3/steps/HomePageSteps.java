package hw3.steps;

import hw3.pages.HomePage;
import org.openqa.selenium.WebElement;

import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public abstract class HomePageSteps {
    public static void performLogin(HomePage homePage) throws IOException {
        homePage.login();
    }

    public static void checkPageUserName(HomePage homePage) {
        assertEquals(homePage.getPageUserName(), "ROMAN IOVLEV");
    }

    public static void checkHeaderSection(HomePage homePage) {
        assertTrue(homePage.isHeaderSectionDisplayed());
        assertEquals(homePage.getHomeMenuTabText(), "HOME");
        assertEquals(homePage.getContactFormMenuTabText(), "CONTACT FORM");
        assertEquals(homePage.getServiceMenuTabText(), "SERVICE");
        assertEquals(homePage.getMetalColorsMenuTabText(), "METALS & COLORS");
    }

    public static void checkImages(HomePage homePage) {
        assertEquals(homePage.getImages().size(), 4);
        for (WebElement element : homePage.getImages()) {
            assertTrue(element.isDisplayed());
        }
    }

    public static void checkTextsUnderImages(HomePage homePage) {
        assertEquals(homePage.getTexts().size(), 4);
        for (WebElement text : homePage.getTexts()) {
            assertTrue(text.isDisplayed());
        }
    }

    public static void assertFrameButton(HomePage homePage) {
        assertTrue(homePage.iframeExists());
    }

    public static void frameButtonExists(HomePage homePage) {
        assertTrue(homePage.getButtonFrame().isDisplayed());
    }

    public static void checkLeftSection(HomePage homePage) {
        assertTrue(homePage.isLeftSectionDisplayed());
    }


}