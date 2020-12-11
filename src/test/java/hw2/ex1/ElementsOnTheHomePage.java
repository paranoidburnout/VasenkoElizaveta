package hw2.ex1;

import hw2.base.BaseTest;

import hw2.enums.LoginUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class ElementsOnTheHomePage extends BaseTest {

    @Test
    public void thePresenceOfMainElementsOnTheHomePage() {
        String menuButtonOnTheHeader = ("HOME\n"
                + "CONTACT FORM\n"
                + "SERVICE\n"
                + "METALS & COLORS");
        String menuButtonOnTheLeft = ("Home\n"
                + "Contact form\n"
                + "Service\n"
                + "Metals & Colors\n"
                + "Elements packs");

        //1.Open test site by URL
        openURL();

        //2.Assert Browser title
        assertTitle("Home Page");

        //3.Perform login
        performLogin(LoginUser.DEFAULT_USER);

        //4.Assert Username is loggined
        assertUserName(LoginUser.DEFAULT_USER);

        //5.Assert that there are 4 items on the header section are displayed and they have proper texts
        WebElement items = driver.findElement(By.cssSelector("ul.uui-navigation.nav"));
        assertItemsOnTheHeaderSection(items, menuButtonOnTheHeader);

        //6.Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> images = driver.findElements(By.cssSelector(".benefit-icon span"));
        checkImagesExistence(images);

        //7.Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> texts = driver.findElements(By.className("benefit-txt"));
        checkTextBelowIcons(texts);

        //8.Assert that there is the iframe with “Frame Button” exist
        assertFrameButton();

        //9.Switch to the iframe and check that there is “Frame Button” in the iframe
        switchToTheFrameAndCheck();

        //10.Switch to original window back
        switchToOriginalWindowBack();

        //11.Assert that there are 5 items in the Left Section are displayed and they have proper text
        WebElement itemsInTheLeft = driver.findElement(By.cssSelector("ul.sidebar-menu"));
        assertItemsOnTheLeftSection(itemsInTheLeft, menuButtonOnTheLeft);
    }
}
