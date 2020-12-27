package hw3.steps;

import hw3.pages.ServicePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public abstract class ServicePageSteps {

    public static void openDifferentElementsPage(ServicePage servicePage) {
        servicePage.clickServicePage();
        servicePage.clickDifferentElements();
    }

    public static void selectWaterCheckbox(ServicePage servicePage) {
        servicePage.clickCheckboxWater();
    }

    public static void selectWindCheckbox(ServicePage servicePage) {
        servicePage.clickCheckboxWind();
    }

    public static void selectRadio(ServicePage servicePage) {
        servicePage.clickRadioButtonSelen();
    }

    public static void assertCheckboxes(ServicePage servicePage) {
        for (WebElement checkbox : servicePage.logWaterCheckbox()) {
            Assert.assertTrue(checkbox.isDisplayed());
        }
        for (WebElement checkbox : servicePage.logWindCheckbox()) {
            Assert.assertTrue(checkbox.isDisplayed());
        }
    }

    public static void assertRadio(ServicePage servicePage) {
        for (WebElement logRadio : servicePage.log()) {
            Assert.assertTrue(logRadio.isDisplayed());
        }
    }

    public static void assertInDropdown(ServicePage servicePage) {
        for (WebElement logDropdrown : servicePage.panelWithLogs()) {
            Assert.assertTrue(logDropdrown.isDisplayed());
        }
    }
}

