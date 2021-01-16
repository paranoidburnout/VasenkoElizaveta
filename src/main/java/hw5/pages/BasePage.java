package hw5.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static hw5.Const.BASE_URL;

public abstract class BasePage {

    protected WebDriver driver;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openHomePage() {
        driver.navigate().to(BASE_URL);
    }

    public String getTitle(String title) {
        return driver.getTitle();
    }
}
