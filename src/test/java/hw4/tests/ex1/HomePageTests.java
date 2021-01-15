package hw4.tests.ex1;

import hw4.tests.base.BaseTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Feature("Check Home page")
@Story("All steps for check")
public class HomePageTests extends BaseTest {

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
