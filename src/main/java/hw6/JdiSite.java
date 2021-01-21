package hw6;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import hw6.complexelements.HeaderMenu;
import hw6.complexelements.HeaderMenuItems;
import hw6.entities.MetalsAndColors;
import hw6.entities.User;
import hw6.pages.JdiHomePage;
import hw6.pages.JdiMetalsColorsPage;


@JSite("https://jdi-testing.github.io/jdi-light/")
public class JdiSite {

    @Url("index.html")
    @Title("Home Page")
    public static JdiHomePage homePage;

    @Url("metals-colors.html")
    @Title("Metal and Colors")
    public static JdiMetalsColorsPage metalsColorsPage;

    @XPath("//ul[contains(@class,'navbar-nav m-l8')]")
    public static HeaderMenu headerMenu;

    public static void open() {
        homePage.open();
        homePage.checkOpened();
    }

    public static String getTitle() {
        return WebPage.getTitle();
    }

    public static void login(User user) {
        homePage.login(user);
    }

    public static void openMetalsAndColorsPage(HeaderMenuItems headerMenuItems) {
        if (headerMenuItems == HeaderMenuItems.METALS_AND_COLORS) {
            headerMenu.getMetalsAndColors().click();
            metalsColorsPage.checkOpened();
        }
    }

    public static void fillMetalAndColor(MetalsAndColors metalAndColor) {
        metalsColorsPage.fillMetalAndColorForm(metalAndColor);
    }
}
