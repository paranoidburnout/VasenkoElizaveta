package hw2.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.List;

import static hw2.base.Const.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BaseTest {

    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    //ex1 and ex2 common steps
    protected void openURL() {
        driver.get(BASE_URL);
    }

    public void assertTitle() {
        assertEquals(driver.getTitle(), titleExpected);
    }

    protected void performLogin() {
        driver.findElement(By.className(userIcon)).click();
        driver.findElement(By.id(userLogin)).sendKeys(login);
        driver.findElement(By.cssSelector(userPassword)).sendKeys(password);
        driver.findElement(By.id(enterButton)).click();
    }

    public void assertUserName() {
        WebElement element = driver.findElement(By.xpath(userNameLocator));
        assertTrue(element.isDisplayed());
        assertEquals(element.getText(), userName);
    }

    //ex1 steps
    public void assertItemsOnTheHeaderSection() {
        WebElement items = driver.findElement(By.cssSelector(headerSection));
        assertTrue(items.isDisplayed());
        assertEquals(items.getText(), menuButtons);
    }

    public void checkImagesExistence() {
        List<WebElement> images = driver.findElements(By.cssSelector(imagesOnHomePage));
        Assert.assertEquals(images.size(), 4);
        for (WebElement img : images) {
            Assert.assertTrue(img.isDisplayed());
        }
    }

    public void checkTextBelowIcons() {
        List<WebElement> texts = driver.findElements(By.className(textsOnHomePage));
        assertEquals(texts.size(), 4);
        for (WebElement text : texts) {
            assertTrue(text.isDisplayed());
        }
    }

    public void assertFrameButton() {
        WebElement frame = driver.findElement(By.id(buttonWithNameFrame));
        boolean existedFrame = frame.isEnabled();
        Assert.assertTrue(existedFrame);
    }

    public void switchToTheFrameAndCheck() {
        WebElement frame = driver.findElement(By.id(buttonWithNameFrame));
        driver.switchTo().frame(frame);
        WebElement iFrameButton = driver.findElement(By.id(buttonFrame));
        assertTrue(iFrameButton.isDisplayed());
    }

    public void switchToOriginalWindowBack() {
        driver.switchTo().defaultContent();
    }

    public void assertItemsOnTheLeftSection() {
        WebElement items = driver.findElement(By.cssSelector(leftSection));
        assertTrue(items.isDisplayed());
        assertEquals(items.getText(), menuButtonsOnTheLeft);
    }

    //ex2 steps
    public void openDifferentElementsPage() {
        WebElement element = driver.findElement((By.xpath(pageService)));
        element.click();
        driver.findElement((By.xpath(differentElementPage)));
        element.click();
        driver.get(URL_DIFF_ELEMENT_PAGES);
    }

    public void selectWaterCheckbox() {
        driver.findElement(By.cssSelector(water)).click();
    }

    public void selectWindCheckbox() {
        driver.findElement(By.cssSelector(wind)).click();
    }

    public void selectRadio() {
        driver.findElement(By.xpath(selen)).click();
    }

    public void selectDropdown() {
        driver.findElement((By.xpath(uuiFormElement))).click();
        driver.findElement((By.xpath(yellow))).click();
    }

    public void assertCheckboxes() {
        List<WebElement> logList = driver.findElements(By.cssSelector(panelBodyListLogs));
        assertTrue(logList.get(2).getText().contains("Wind: condition changed to true"));
        assertTrue(logList.get(3).getText().contains("Water: condition changed to true"));
    }

    public void assertRadio() {
        List<WebElement> logsList = driver.findElements(By.cssSelector(panelBodyListLogs));
        assertTrue(logsList.get(1).getText().contains("metal: value changed to Selen"));
    }

    public void assertInDropdown() {
        List<WebElement> logsList = driver.findElements(By.cssSelector(panelBodyListLogs));
        assertTrue(logsList.get(0).getText().contains("Colors: value changed to Yellow"));
    }

    public static final String BASE_URL = "https://jdi-testing.github.io/jdi-light/index.html";
    public static final String URL_DIFF_ELEMENT_PAGES = "https://jdi-testing.github.io/jdi-light/different-elements.html";
}

