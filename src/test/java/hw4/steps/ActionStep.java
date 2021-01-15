package hw4.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static hw4.Const.login;
import static hw4.Const.password;

public class ActionStep extends BaseStep {

    public ActionStep(WebDriver driver) {
        super(driver);
    }

    @Step("Perform login")
    public void loggIn() {
        homePage.login(login, password);
    }

    @Step("Switch to the iframe")
    public void switchToFrame() {
        homePage.switchToFrame();
    }

    @Step("Switch to original window back")
    public void switchBackToOriginalWindow() {
        homePage.switchBackToOriginalWindow();
    }

    @Step("Open through the header menu Different Elements Page")
    public void openDifferentElementsPage() {
        servicePage.openDifferentElementsPage();
    }

    @Step("Select checkboxes: 'WATER', 'WIND'")
    public void selectCheckboxes() {
        servicePage.selectWaterCheckbox();
        servicePage.selectWindCheckbox();
    }

    @Step("Select radio: 'SELEN'")
    public void selectRadio() {
        servicePage.selectRadio();
    }

    @Step("Select in dropdown: 'YELLOW'")
    public void selectInDropdown() {
        servicePage.selectYellowInDropDownMenu();
    }
}
