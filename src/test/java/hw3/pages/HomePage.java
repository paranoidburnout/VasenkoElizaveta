package hw3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import static org.testng.Assert.assertEquals;
import static hw3.Const.BASE_URL;

public class HomePage {
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

    public void login() throws IOException {
        InputStream input = new FileInputStream("src/test/resources/user.properties");
        Properties prop = new Properties();
        prop.load(input);
        dropdownForm.click();
        loginForm.sendKeys(prop.getProperty("user.name"));
        passwordForm.sendKeys(prop.getProperty("user.password"));
        enterButton.click();
    }

    public String getPageUserName() {
        return user.getText();
    }

    public List<WebElement> getImages() {
        return images;
    }

    public List<WebElement> getTexts(){return texts;}

    public boolean iframeExists() {
        return frame != null;
    }

    public String getHomeMenuTabText() {
        return homeMenuTab.getText();
    }

    public String getContactFormMenuTabText() {
        return contactFormMenuTab.getText();
    }

    public String getServiceMenuTabText() {
        return serviceMenuTab.getText();
    }

    public String getMetalColorsMenuTabText() {
        return metalColorsMenuTab.getText();
    }

    public WebElement getFrame() {
        return frame;
    }

    public WebElement getButtonFrame() {
        return buttonFrame;
    }

    public Boolean isLeftSectionDisplayed() {
        return itemsOnTheLeftSection.isDisplayed();
    }
    public Boolean isHeaderSectionDisplayed(){
        return itemsOnTheHeader.isDisplayed();
    }

}
