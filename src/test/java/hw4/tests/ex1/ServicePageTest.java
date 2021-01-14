package hw4.tests.ex1;

import hw4.tests.base.BaseTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Feature("Check Different Elements Page")
@Story("All steps for check")
public class ServicePageTest extends BaseTest {

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
