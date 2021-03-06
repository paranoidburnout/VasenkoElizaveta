package hw4.tests.ex2;

import hw4.tests.base.BaseTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Feature(value = "Check Home page")
@Story(value = "All steps for check")
public class FailTest extends BaseTest {

    @Test(description = "Home page testing, but this need fail")
    public void theFailPresenceOfMainElementsOnTheHomePage() {
        actionStep.openHomePage();
        assertionStep.assertTitle();
        actionStep.loggIn();
        assertionStep.assertUsername();
        assertionStep.assertItemsOnTheHeaderAreDisplayed();
        assertionStep.assertItemsOnTheHeaderHaveTexts();
        assertionStep.falseVerifyImagesOnTheHomePageAreDisplayed();
        assertionStep.assertImagesOnTheHeaderHaveTexts();
        assertionStep.assertFrameExist();
        actionStep.switchToFrame();
        assertionStep.assertFrameButtonExist();
        actionStep.switchBackToOriginalWindow();
        assertionStep.verifyLeftElementsAreDisplayed();
    }
}
