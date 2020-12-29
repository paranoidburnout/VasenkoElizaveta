package hw3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

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
        super(driver);
    }

    public void login(String login, String password) {
        dropdownForm.click();
        loginForm.sendKeys(login);
        passwordForm.sendKeys(password);
        enterButton.click();
    }

    public WebElement getUser() {
        return user;
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
