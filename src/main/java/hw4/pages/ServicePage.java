package hw4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ServicePage extends BasePage {

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
        super(driver);
    }

    public void openDifferentElementsPage() {
        servicePage.click();
        differentElementsPageMenuOption.click();
    }

    public void selectWaterCheckbox() {
        checkboxWater.click();
    }

    public void selectWindCheckbox() {
        checkboxWind.click();
    }

    public void selectRadio() {
        radioButtonSelen.click();
    }

    public void selectYellowInDropDownMenu() {
        Select colors = new Select(colorsDropDownMenu);
        colors.selectByVisibleText("Yellow");
    }

    public List<WebElement> logWaterCheckbox() {
        return getLogsList("Water: condition changed to true");
    }

    public List<WebElement> logWindCheckbox() {
        return getLogsList("Wind: condition changed to true");
    }

    public List<WebElement> log() {
        return getLogsList("metal: value changed to  Selen");
    }

    public List<WebElement> panelWithLogs() {
        return getLogsList("Colors: value changed to Yellow");
    }

    public static List<WebElement> getLogsList(String word) {
        return logsList;
    }
}
