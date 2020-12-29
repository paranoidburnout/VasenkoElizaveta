package hw3.base;

import hw3.Const;
import hw3.pages.HomePage;
import hw3.pages.ServicePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.List;

import static hw3.Const.BASE_URL;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public abstract class BaseTest {

    protected WebDriver driver;
    protected HomePage homePage;
    protected ServicePage servicePage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        servicePage = new ServicePage(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }

    public void openHomePage() {
        driver.navigate().to(BASE_URL);
    }

    public void assertTitle(String titleExpected) {
        assertEquals(driver.getTitle(), titleExpected);
    }

    public void getPageUserName(WebElement user, String username) {
        assertEquals(user.getText(), Const.username);
    }

    //ex1
    public void checkHeaderSection(WebElement itemsOnTheHeader, WebElement homeMenuTab, WebElement contactFormMenuTab,
                                   WebElement serviceMenuTab, WebElement metalColorsMenuTab) {
        assertTrue(itemsOnTheHeader.isDisplayed());
        assertEquals(homeMenuTab.getText(), "HOME");
        assertEquals(contactFormMenuTab.getText(), "CONTACT FORM");
        assertEquals(serviceMenuTab.getText(), "SERVICE");
        assertEquals(metalColorsMenuTab.getText(), "METALS & COLORS");
    }

    public void checkImages(List<WebElement> images) {
        assertEquals(images.size(), 4);
        for (WebElement element : images) {
            assertTrue(element.isDisplayed());
        }
    }

    public void checkTextsUnderImages(List<WebElement> texts) {
        assertEquals(texts.size(), 4);
        for (WebElement text : texts) {
            assertTrue(text.isDisplayed());
        }
    }

    public void assertFrameButton(WebElement frame) {
        boolean existedFrame = frame.isEnabled();
        Assert.assertTrue(existedFrame);
    }

    public void frameButtonExists(WebElement buttonFrame) {
        assertTrue(buttonFrame.isDisplayed());
    }

    public void checkLeftSection(WebElement itemsOnTheLeftSection) {
        assertTrue(itemsOnTheLeftSection.isDisplayed());
    }

    //ex2
    public void openDifferentElementsPage(WebElement servicePage, WebElement differentElementsPageMenuOption) {
        servicePage.click();
        differentElementsPageMenuOption.click();
    }

    public void selectWaterCheckbox(WebElement checkboxWater) {
        checkboxWater.click();
    }

    public void selectWindCheckbox(WebElement checkboxWind) {
        checkboxWind.click();
    }

    public void selectRadio(WebElement radioButtonSelen) {
        radioButtonSelen.click();
    }

    public void selectYellowInDropDownMenu(WebElement colorsDropDownMenu) {
        Select colors = new Select(colorsDropDownMenu);
        colors.selectByVisibleText("Yellow");
    }

    public void assertCheckboxes(List<WebElement> getLogsList) {
        for (WebElement checkbox : getLogsList) {
            Assert.assertTrue(checkbox.isDisplayed());
        }
    }

    public void assertRadio(List<WebElement> getLogsList) {
        for (WebElement logRadio : getLogsList) {
            Assert.assertTrue(logRadio.isDisplayed());
        }
    }

    public void assertInDropdown(List<WebElement> getLogsList) {
        for (WebElement logDropdown : getLogsList) {
            Assert.assertTrue(logDropdown.isDisplayed());
        }
    }
}
