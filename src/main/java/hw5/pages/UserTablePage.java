package hw5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class UserTablePage extends BasePage {

    @FindBy(css = "tbody")
    private WebElement body;

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


    @FindBy(xpath = "//tbody//tr//td[2]//select")
    private List<WebElement> dropdowns;

    @FindBy(xpath = "//li[contains(text(), '%s')]")
    private static List<WebElement> logsList;

    public UserTablePage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getNumberTypeDropdowns() {
        return numberTypeDropdowns;
    }

    public List<WebElement> getUsernames() {
        return usernames;
    }

    public List<WebElement> getDescriptionTextsUnderImages() {
        return descriptionTextsUnderImages;
    }

    public List<WebElement> getCheckboxes() {
        return checkboxes;
    }

    public WebElement getDropdownValues() {
        return dropdownValues;
    }

    public List<WebElement> getDropdown() {
        return dropdowns;
    }

    public void selectVipCheckbox() {
        dropdownValues.click();
    }

    public void openUserTable() {
        servicePageOnTop.click();
        userTableButton.click();
    }

    public List<String> getNumbersValues() {
        return body.findElements(By.xpath("//td[1]")).stream()
                .map(p -> p.getText())
                .map(p -> p.trim())
                .collect(Collectors.toList());
    }

    public List<String> getDescriptionOfUser() {
        return body.findElements(By.tagName("span")).stream()
                .map(p -> p.getText())
                .map(p -> p.trim())
                .map(p -> p.replaceAll("\\s", " "))
                .collect(Collectors.toList());
    }

    public List<String> getUserNamesText() {
        return getUsernames().stream()
                .map(p -> p.getText())
                .map(p -> p.trim())
                .collect(Collectors.toList());
    }

    public List<WebElement> getValuesOfDropdown() {
        return new Select(getDropdown().get(0)).getOptions();
    }

    public static List<WebElement> getLogsList(String word, String text) {
        return logsList;
    }

    public List<WebElement> logRowBack(String text) {
        return getLogsList("Vip: condition changed to true", text);
    }
}
