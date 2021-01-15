package hw4.steps;

import hw4.pages.HomePage;
import hw4.pages.ServicePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public abstract class BaseStep {

    protected HomePage homePage;
    protected ServicePage servicePage;

    protected BaseStep(WebDriver driver) {
        homePage = new HomePage(driver);
        servicePage = new ServicePage(driver);
    }

    @Step("Open test site by URL")
    public void openHomePage() {
        homePage.openHomePage();
    }
}
