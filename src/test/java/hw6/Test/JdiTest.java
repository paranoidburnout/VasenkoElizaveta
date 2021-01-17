package hw6.Test;

import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.init.PageFactory;
import hw6.DataProviderJsonForMetalsColorPage;
import hw6.JdiSite;
import hw6.Json.JsonDataProvider;
import hw6.complexelements.HeaderMenuItems;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

@Test(dataProvider = "DataProviderJson", dataProviderClass = JsonDataProvider.class)
public class JdiTest {

    @BeforeSuite
    public void beforeSuite() {
        PageFactory.initSite(JdiSite.class);
    }

    @AfterSuite
    public void afterSuite() {
        WebDriverUtils.killAllSeleniumDrivers();
    }

    @Test
    public void jdiTest(DataProviderJsonForMetalsColorPage dataProviderJsonForMetalsColorPage) {

        JdiSteps steps = new JdiSteps();

        //Login on JDI site as User
        steps.openSite();
        steps.loginWasSuccessful();

        //Open Metals & Colors page by Header menu
        steps.clickHeaderMenu(HeaderMenuItems.METALS_AND_COLORS);
        steps.pageIsOpened();

        //Fill form Metals & Colors by data below
        steps.fillPageWithDataFromJson(dataProviderJsonForMetalsColorPage);

        //Submit form Metals & Colors
        steps.submitForm();

        //Result sections should contains data  below
        steps.resultShouldContainsData(dataProviderJsonForMetalsColorPage);
    }
}
