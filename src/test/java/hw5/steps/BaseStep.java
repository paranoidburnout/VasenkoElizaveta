package hw5.steps;

import hw5.pages.HomePage;
import hw5.pages.ServicePage;
import hw5.driver.WebDriverSingleton;
import hw5.pages.UserTablePage;
import org.openqa.selenium.WebDriver;

public abstract class BaseStep {
    protected HomePage homePage;
    protected ServicePage servicePage;
    protected UserTablePage userTablePage;

    public BaseStep() {
        WebDriver driver = WebDriverSingleton.getDriver();
        homePage = new HomePage(driver);
        servicePage = new ServicePage(driver);
        userTablePage = new UserTablePage(driver);
    }
}
