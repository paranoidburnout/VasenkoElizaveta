package hw2.base;

import hw2.enums.LoginUser;
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

public abstract class BaseTest {

    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    //ex1 and ex2 common steps
    public void openURL() {
        driver.get(BASE_URL);
    }

    public void assertTitle(String titleExpected) {
        assertEquals(driver.getTitle(), titleExpected);
    }

    public void performLogin(LoginUser login) {
        driver.findElement(By.className("profile-photo")).click();
        driver.findElement(By.id("name")).sendKeys(login.getLogin());
        driver.findElement(By.cssSelector("#password")).sendKeys(login.getPassword());
        driver.findElement(By.id("login-button")).click();
    }

    public void assertUserName(LoginUser username) {
        WebElement element = driver.findElement(By.xpath("//*[@class='profile-photo']//span"));
        assertTrue(element.isDisplayed());
        assertEquals(element.getText(), username.getUsername());
    }

    //ex1 steps
    public void assertItemsOnTheHeaderSection(WebElement assertionData, String expectedHeaders) {
        assertTrue(assertionData.isDisplayed());
        assertEquals(assertionData.getText(), expectedHeaders);
    }

    public void checkImagesExistence(List<WebElement> images) {
        Assert.assertEquals(images.size(), 4);
        for (WebElement img : images) {
            Assert.assertTrue(img.isDisplayed());
        }
    }

    public void checkTextBelowIcons(List<WebElement> texts) {
        assertEquals(texts.size(), 4);
        for (WebElement text : texts) {
            assertTrue(text.isDisplayed());
        }
    }

    public void assertFrameButton() {
        WebElement frame = driver.findElement(By.id("frame"));
        boolean existedFrame = frame.isEnabled();
        Assert.assertTrue(existedFrame);
    }

    public void switchToTheFrameAndCheck() {
        WebElement frame = driver.findElement(By.id("frame"));
        driver.switchTo().frame(frame);
        WebElement iFrameButton = driver.findElement(By.id("button-frame"));
        assertTrue(iFrameButton.isDisplayed());
    }

    public void switchToOriginalWindowBack() {
        driver.switchTo().defaultContent();
    }

    public void assertItemsOnTheLeftSection(WebElement assertionData, String expectedHeaders) {
        assertTrue(assertionData.isDisplayed());
        assertEquals(assertionData.getText(), expectedHeaders);
    }

    //ex2 steps
    public void openDifferentElementsPage() {
        WebElement element = driver.findElement((By.xpath("//a/span[contains(text(),'Service')]")));
        element.click();
        driver.findElement((By.xpath("//a[contains(text(), 'Different elements')]")));
        element.click();
        driver.get("https://jdi-testing.github.io/jdi-light/different-elements.html");
    }

    public void selectWaterCheckbox(String input) {
        driver.findElement(By.xpath(String.format("//*[@class = 'checkbox-row']/label[contains(., '%s')]", input))).click();
    }

    public void selectWindCheckbox(String input) {
        driver.findElement(By.xpath(String.format("//*[@class = 'checkbox-row']/label[contains(., '%s')]", input))).click();
    }

    public void selectRadio(String input) {
        driver.findElement(By.xpath(String.format("//*[@class = 'checkbox-row']/label[contains(., '%s')]", input))).click();
    }

    public void selectDropdown(String input) {
        driver.findElement((By.xpath("//select[@class = 'uui-form-element']"))).click();
        driver.findElement((By.xpath(String.format("//*[@class = 'uui-form-element']/option[contains(., '%s')]", input)))).click();
    }

    public void assertCheckboxes(String checkbox, boolean status) {
        Assert.assertTrue(status);
        List<WebElement> list = driver.findElements(By.cssSelector("ul.panel-body-list.logs li"));
        status = list
                .stream()
                .map(WebElement::getText)
                .anyMatch(s -> s.contains(checkbox));

        status = list
                .stream()
                .map(WebElement::getText)
                .allMatch(s -> s.contains(checkbox));

    }

    public void assertRadio(String radio, String typeValue) {
        List<WebElement> list = driver.findElements(By.cssSelector("ul.panel-body-list.logs li"));
        typeValue = String.valueOf(list
                .stream()
                .map(WebElement::getText)
                .anyMatch(s -> s.contains(radio)));
    }

    public void assertInDropdown(String dropdown, String typeValue) {
        List<WebElement> list = driver.findElements(By.cssSelector("ul.panel-body-list.logs li"));
        typeValue = String.valueOf(list
                .stream()
                .map(WebElement::getText)
                .anyMatch(s -> s.contains(dropdown)));
    }
}

