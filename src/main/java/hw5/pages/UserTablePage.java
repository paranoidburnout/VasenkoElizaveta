package hw5.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UserTablePage extends BasePage {

    @FindBy(xpath = "//a[contains(. ,'Service')]")
    private WebElement servicePageOnTop;

    @FindBy(xpath = "//a[text()='User Table ']")
    private WebElement userTableButton;

    @FindBy(css = "tbody > tr")
    private List<WebElement> numberTypeDropdowns;

    @FindBy(css = "td > a")
    private List<WebElement> usernames;

    @FindBy(css = ".user-descr")
    private List<WebElement> descriptionTextsUnderImages;

    @FindBy(xpath = "//input[@type = 'checkbox']")
    private List<WebElement> checkboxes;

    @FindBy(id = "ivan")
    private WebElement dropdownValues;

    @FindBy(xpath = "//li[contains(text(), '%s')]")
    private static List<WebElement> logsList;

    public UserTablePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getDropdownValues() {
        return dropdownValues;
    }

    public void selectVipCheckbox() {
        dropdownValues.click();
    }

    public void openUserTable() {
        servicePageOnTop.click();
        userTableButton.click();
    }

    public static List<WebElement> getLogsList(String word, String text) {
        return logsList;
    }

    public List<WebElement> logRowBack(String text) {
        return getLogsList("Vip: condition changed to true", text);
    }
}
