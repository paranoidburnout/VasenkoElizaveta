package hw6.Test;

import com.epam.jdi.light.elements.composite.WebPage;
import hw6.DataProviderJsonForMetalsColorPage;
import hw6.JdiSite;
import hw6.complexelements.HeaderMenuItems;
import org.testng.Assert;

import static hw6.JdiSite.metalsColorsPage;
import static hw6.entities.User.ROMAN;
import static java.lang.String.format;

public class JdiSteps {

    public JdiSteps() {
    }

    public void openSite() {
        JdiSite.open();
    }

    public void loginWasSuccessful() {
        JdiSite.login(ROMAN);
        String actualUserName = JdiSite.homePage.getUserName();
        Assert.assertEquals(actualUserName, ROMAN.getFullName(),
                format(String.valueOf(ROMAN), actualUserName));
    }

    public void clickHeaderMenu(HeaderMenuItems metalsAndColors) {
        JdiSite.clickItemOfHeaderMenu(metalsAndColors);
    }

    public void pageIsOpened() {
        metalsColorsPage.checkOpened();
    }

    public void fillPageWithDataFromJson(DataProviderJsonForMetalsColorPage dataProviderJsonForMetalsColorPage) {
        WebPage.refresh();
        JdiSite.metalsColorsPage.fill(dataProviderJsonForMetalsColorPage);
    }

    public void submitForm() {
        metalsColorsPage.submit();
    }

    public void resultShouldContainsData(DataProviderJsonForMetalsColorPage dataJson) {
        int expected = dataJson.getSumOfElementsSummary();
        Assert.assertEquals(JdiSite.metalsColorsPage.getLog().getSummary(), Integer.valueOf(expected));
        DataProviderJsonForMetalsColorPage actualDataWithoutSummary = getObjectWithDataFromSite();
        Assert.assertEquals(dataJson, actualDataWithoutSummary);
    }

    private DataProviderJsonForMetalsColorPage getObjectWithDataFromSite() {
        DataProviderJsonForMetalsColorPage actualData = new DataProviderJsonForMetalsColorPage();
        actualData.setColor(JdiSite.metalsColorsPage.getLog().getColor());
        actualData.setElements(JdiSite.metalsColorsPage.getLog().getElements());
        actualData.setMetals(JdiSite.metalsColorsPage.getLog().getMetals());
        actualData.setVegetables(JdiSite.metalsColorsPage.getLog().getVegetables());

        return actualData;
    }
}
