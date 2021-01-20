package hw6.Test;

import com.epam.jdi.light.elements.composite.WebPage;
import hw6.JdiSite;
import hw6.complexelements.HeaderMenuItems;
import hw6.entities.MetalsAndColors;
import hw6.entities.User;
import org.testng.Assert;

import static hw6.entities.User.ROMAN;
import static java.lang.String.format;

public class JdiSteps {

    public JdiSteps() {
    }

    public void openSite() {
        JdiSite.open();
    }

    public void login(User user) {
        JdiSite.login(ROMAN);
        String actualUserName = JdiSite.homePage.getUserName();
        Assert.assertEquals(actualUserName, ROMAN.getFullName(),
                format(String.valueOf(ROMAN), actualUserName));
        Assert.assertEquals(user.getFullName(), "ROMAN IOVLEV");
    }

    public void openMetalAndColorsPage(HeaderMenuItems metalsAndColors) {
        JdiSite.openMetalsAndColorsPage(metalsAndColors);
    }


    public void fillPageByMetalsAndColors(MetalsAndColors metalsAndColors) {
        WebPage.refresh();
        JdiSite.metalsColorsPage.fillMetalAndColorForm(metalsAndColors);
    }


    public void resultShouldContainsData(MetalsAndColors metalsAndColors) {
        int expected = metalsAndColors.getSumOfElementsSummary();
        Assert.assertEquals(JdiSite.metalsColorsPage.getLog().getSummary(), Integer.valueOf(expected));
        MetalsAndColors actualDataWithoutSummary = getObjectWithDataFromSite();
        Assert.assertEquals(metalsAndColors, actualDataWithoutSummary);
    }

    private MetalsAndColors getObjectWithDataFromSite() {
        MetalsAndColors actualData = new MetalsAndColors();
        actualData.setColor(JdiSite.metalsColorsPage.getLog().getColor());
        actualData.setElements(JdiSite.metalsColorsPage.getLog().getElements());
        actualData.setMetals(JdiSite.metalsColorsPage.getLog().getMetals());
        actualData.setVegetables(JdiSite.metalsColorsPage.getLog().getVegetables());

        return actualData;
    }
}
