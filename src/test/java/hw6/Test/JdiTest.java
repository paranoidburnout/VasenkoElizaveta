package hw6.Test;

import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.init.PageFactory;
import hw6.DataFromJsonForMetalsColorPage;
import hw6.JdiSite;
import hw6.Json.JsonDataProvider;
import hw6.complexelements.HeaderMenuItems;
import hw6.entities.User;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class JdiTest {

    private JdiSteps steps;

    @BeforeSuite
    public void beforeSuite() {
        PageFactory.initSite(JdiSite.class);
        steps= new JdiSteps();
    }

    @AfterSuite
    public void afterSuite() {
        WebDriverUtils.killAllSeleniumDrivers();
    }

    @Test(dataProvider = "DataProviderJson", dataProviderClass = JsonDataProvider.class)
    public void jdiTest(DataFromJsonForMetalsColorPage dataProviderJsonForMetalsColorPage) {

        //Login on JDI site as User
        steps.openSite();
        steps.loginWasSuccessful(User.ROMAN);

        //Open Metals & Colors page by Header menu
        steps.clickHeaderMenu(HeaderMenuItems.METALS_AND_COLORS);
        steps.pageIsOpened(HeaderMenuItems.METALS_AND_COLORS);

        //Fill form Metals & Colors by data below
        steps.fillPageWithData(dataProviderJsonForMetalsColorPage);

        //Submit form Metals & Colors
        steps.submitForm();

        //Result sections should contains data  below
        steps.resultShouldContainsData(dataProviderJsonForMetalsColorPage);
    }
}
