package hw3.pages;

import hw3.base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static hw3.Const.BASE_URL;

public class HomePage extends BaseTest {

    protected WebDriver driver;

    @FindBy(className = "profile-photo")
    private WebElement dropdownForm;

    @FindBy(id = "name")
    private WebElement loginForm;

    @FindBy(css = "#password")
    private WebElement passwordForm;

    @FindBy(id = "login-button")
    private WebElement enterButton;

    @FindBy(xpath = "//*[@class='profile-photo']//span")
    private WebElement user;

    @FindBy(css = "ul.uui-navigation.nav")
    private WebElement itemsOnTheHeader;

    @FindBy(linkText = "HOME")
    private WebElement homeMenuTab;

    @FindBy(linkText = "CONTACT FORM")
    private WebElement contactFormMenuTab;

    @FindBy(linkText = "SERVICE")
    private WebElement serviceMenuTab;

    @FindBy(linkText = "METALS & COLORS")
    private WebElement metalColorsMenuTab;

    @FindBy(css = ".benefit-icon span")
    private List<WebElement> images;

    @FindBy(css = ".benefit-txt")
    private List<WebElement> texts;

    @FindBy(id = "frame")
    private WebElement frame;

    @FindBy(id = "button-frame")
    private WebElement buttonFrame;

    @FindBy(css = "ul.sidebar-menu")
    private WebElement itemsOnTheLeftSection;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void openHomePage() {
        driver.navigate().to(BASE_URL);
    }

    public void assertTitle(String titleExpected) {
        assertEquals(driver.getTitle(), titleExpected);
    }

    public void login(String login, String password) {
        dropdownForm.click();
        loginForm.sendKeys(login);
        passwordForm.sendKeys(password);
        enterButton.click();
    }

    public HomePage getPageUserName(String username) {
        equalsText(user, username);
        return this;
    }

    public WebElement getItemsOnTheHeader() {
        return itemsOnTheHeader;
    }

    public WebElement getHomeMenuTab() {
        return homeMenuTab;
    }

    public WebElement getContactFormMenuTab() {
        return contactFormMenuTab;
    }

    public WebElement getServiceMenuTab() {
        return serviceMenuTab;
    }

    public WebElement getMetalColorsMenuTab() {
        return metalColorsMenuTab;
    }

    public List<WebElement> getImages() {
        return images;
    }

    public List<WebElement> getTexts() {
        return texts;
    }

    public WebElement getFrame() {
        return frame;
    }

    public WebElement getButtonFrame() {
        return buttonFrame;
    }

    public WebElement getItemsOnTheLeftSection() {
        return itemsOnTheLeftSection;
    }
}
