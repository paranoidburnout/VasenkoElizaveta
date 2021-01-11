package hw4.tests.ex2;

import hw4.listeners.AllureListener;
import hw4.tests.base.BaseTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({AllureListener.class})
public class ServicePageTest extends BaseTest {

    @Feature(value = "Check Different Elements Page")
    @Story(value = "All steps for check")
    @Test(description = "Different Elements Page testing")
    public void presenceElementsOnTheServicePageDisplayed() {
        actionStep.openHomePage();
        assertionStep.assertTitle();
        actionStep.loggIn();
        assertionStep.assertUsername();
        actionStep.openDifferentElementsPage();
        actionStep.selectCheckboxes();
        actionStep.selectRadio();
        actionStep.selectInDropdown();
        assertionStep.assertCheckboxes();
        assertionStep.assertRadio();
        assertionStep.assertInDropdown();
    }
}
