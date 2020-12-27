package hw3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ServicePage {

    protected WebDriver driver;

    @FindBy(xpath = "//a/span[contains(text(),'Different elements')]")
    private WebElement differentElementsPageMenuOption;

    @FindBy(xpath = "//a/span[contains(text(),'Service')]")
    private WebElement servicePage;

    @FindBy(xpath = "//li[contains(text(), '%s')]")
    private static List<WebElement> logsList;

    @FindBy(xpath = "//*[@class = 'checkbox-row']/label[contains(., 'Water')]")
    private WebElement checkboxWater;

    @FindBy(xpath = "//*[@class = 'checkbox-row']/label[contains(., 'Wind')]")
    private WebElement checkboxWind;

    @FindBy(xpath = "//*[@class = 'checkbox-row']/label[contains(., 'Selen')]")
    private WebElement radioButtonSelen;

    @FindBy(xpath = "//select[@class = 'uui-form-element']")
    private WebElement colorsDropDownMenu;

    public ServicePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickServicePage() {
        servicePage.click();
    }

    public void clickDifferentElements() {
        differentElementsPageMenuOption.click();
    }

    public void clickCheckboxWater() {
        checkboxWater.click();
    }

    public void clickCheckboxWind() {
        checkboxWind.click();
    }

    public void clickRadioButtonSelen() {
        radioButtonSelen.click();
    }

    public void selectYellowInDropDownMenu() {
        Select colors = new Select(colorsDropDownMenu);
        colors.selectByVisibleText("Yellow");
    }

    public List<WebElement> logWaterCheckbox() {
        return getLogRowsByKeyWord("Water: condition changed to true");
    }

    public List<WebElement> logWindCheckbox() {
        return getLogRowsByKeyWord("Wind: condition changed to true");
    }

    public List<WebElement> log() {
        return getLogRowsByKeyWord("metal: value changed to  Selen");
    }

    public List<WebElement> panelWithLogs() {
        return getLogRowsByKeyWord("Colors: value changed to Yellow");
    }


    public static List<WebElement> getLogRowsByKeyWord(String word) {
        return logsList;
    }

}
