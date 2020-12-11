package hw2.base;

public class Const {

    //names or titles
    public static final String titleExpected = "Home Page";
    public static final String login = "Roman";
    public static final String password = "Jdi1234";
    public static final String userName = "ROMAN IOVLEV";
    public static final String menuButtons = "HOME\n"
            + "CONTACT FORM\n"
            + "SERVICE\n"
            + "METALS & COLORS";
    public static final String menuButtonsOnTheLeft = "Home\n"
            + "Contact form\n"
            + "Service\n"
            + "Metals & Colors\n"
            + "Elements packs";

    //locators
    public static final String userIcon = "profile-photo";
    public static final String userLogin = "name";
    public static final String userPassword = "#password";
    public static final String enterButton = "login-button";
    public static final String userNameLocator = "//*[@class='profile-photo']//span";
    public static final String headerSection = "ul.uui-navigation.nav";
    public static final String leftSection = "ul.sidebar-menu";
    public static final String imagesOnHomePage = ".benefit-icon span";
    public static final String textsOnHomePage = "benefit-txt";
    public static final String pageService = "//a/span[contains(text(),'Service')]";
    public static final String differentElementPage = "//a[contains(text(), 'Different elements')]";
    public static final String uuiFormElement = "//select[@class = 'uui-form-element']";
    public static final String yellow = "//*[@class = 'uui-form-element']/option[contains(., 'Yellow')]";
    public static final String water = "* label:nth-child(1) > input[type=checkbox]";
    public static final String wind = "* label:nth-child(3) > input[type=checkbox]";
    public static final String selen = "//div[3]//label[4]//input[1]";
    public static final String panelBodyListLogs = "ul.panel-body-list.logs li";
    public static final String buttonWithNameFrame = "frame";
    public static final String buttonFrame = "button-frame";
}
