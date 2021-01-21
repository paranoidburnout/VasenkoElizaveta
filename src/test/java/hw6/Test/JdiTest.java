package hw6.Test;

import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.init.PageFactory;
import hw6.JdiSite;
import hw6.Json.JsonDataProvider;
import hw6.complexelements.HeaderMenuItems;
import hw6.entities.MetalsAndColors;
import hw6.entities.User;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class JdiTest {

    private JdiSteps steps;

    @BeforeSuite
    public void beforeSuite() {
        PageFactory.initSite(JdiSite.class);
        steps = new JdiSteps();
    }

    @AfterSuite
    public void afterSuite() {
        WebDriverUtils.killAllSeleniumDrivers();
    }

    @Test(dataProvider = "DataProviderJson", dataProviderClass = JsonDataProvider.class)
    public void jdiTest(MetalsAndColors metalAndColor) {
        steps.openSite();
        steps.login(User.ROMAN);
        steps.openMetalAndColorsPage(HeaderMenuItems.METALS_AND_COLORS);
        steps.fillPageByMetalsAndColors(metalAndColor);
        steps.resultShouldContainsData(metalAndColor);
    }
}
