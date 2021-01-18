package hw6.Test;

import com.epam.jdi.light.elements.composite.WebPage;
import hw6.DataFromJsonForMetalsColorPage;
import hw6.JdiSite;
import hw6.complexelements.HeaderMenuItems;
import hw6.entities.User;
import org.testng.Assert;

import static hw6.JdiSite.getTitle;
import static hw6.JdiSite.metalsColorsPage;
import static hw6.entities.User.ROMAN;
import static java.lang.String.format;

public class JdiSteps {

    public JdiSteps() {
    }

    public void openSite() {
        JdiSite.open();
    }

    public void loginWasSuccessful(User user) {
        JdiSite.login(ROMAN);
        String actualUserName = JdiSite.homePage.getUserName();
        Assert.assertEquals(actualUserName, ROMAN.getFullName(),
                format(String.valueOf(ROMAN), actualUserName));
        Assert.assertEquals(user.getFullName(), "ROMAN IOVLEV");
    }

    public void clickHeaderMenu(HeaderMenuItems metalsAndColors) {
        JdiSite.clickItemOfHeaderMenu(metalsAndColors);
    }

    public void pageIsOpened(HeaderMenuItems metalsAndColors) {
        metalsColorsPage.checkOpened();
        Assert.assertEquals(getTitle(), "Metal and Colors", String.valueOf(metalsAndColors));
    }

    public void fillPageWithData(DataFromJsonForMetalsColorPage dataProviderJsonForMetalsColorPage) {
        WebPage.refresh();
        JdiSite.metalsColorsPage.fill(dataProviderJsonForMetalsColorPage);
    }

    public void submitForm() {
        metalsColorsPage.submit();
    }

    public void resultShouldContainsData(DataFromJsonForMetalsColorPage dataJson) {
        int expected = dataJson.getSumOfElementsSummary();
        Assert.assertEquals(JdiSite.metalsColorsPage.getLog().getSummary(), Integer.valueOf(expected));
        DataFromJsonForMetalsColorPage actualDataWithoutSummary = getObjectWithDataFromSite();
        Assert.assertEquals(dataJson, actualDataWithoutSummary);
    }

    private DataFromJsonForMetalsColorPage getObjectWithDataFromSite() {
        DataFromJsonForMetalsColorPage actualData = new DataFromJsonForMetalsColorPage();
        actualData.setColor(JdiSite.metalsColorsPage.getLog().getColor());
        actualData.setElements(JdiSite.metalsColorsPage.getLog().getElements());
        actualData.setMetals(JdiSite.metalsColorsPage.getLog().getMetals());
        actualData.setVegetables(JdiSite.metalsColorsPage.getLog().getVegetables());

        return actualData;
    }
}
