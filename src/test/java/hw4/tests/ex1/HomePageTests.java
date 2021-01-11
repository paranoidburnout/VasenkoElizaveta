package hw4.tests.ex1;

import hw4.listeners.AllureListener;
import hw4.tests.base.BaseTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({AllureListener.class})
public class HomePageTests extends BaseTest {

    @Feature(value = "Check Home page")
    @Story(value = "All steps for check")
    @Test(description = "Home page testing")
    public void thePresenceOfMainElementsOnTheHomePage() {
        actionStep.openHomePage();
        assertionStep.assertTitle();
        actionStep.loggIn();
        assertionStep.assertUsername();
        assertionStep.assertItemsOnTheHeaderAreDisplayed();
        assertionStep.assertItemsOnTheHeaderHaveTexts();
        assertionStep.verifyImagesOnTheHomePageAreDisplayed();
        assertionStep.assertImagesOnTheHeaderHaveTexts();
        assertionStep.assertFrameExist();
        actionStep.switchToFrame();
        assertionStep.assertFrameButtonExist();
        actionStep.switchBackToOriginalWindow();
        assertionStep.verifyLeftElementsAreDisplayed();
    }
}
