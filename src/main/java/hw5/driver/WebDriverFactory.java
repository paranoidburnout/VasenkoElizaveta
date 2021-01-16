package hw5.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {

    private static final String CHROME = "CHROME";

    private WebDriverFactory() {}

    public static WebDriver createWebDriver(String browserName) {
        WebDriver driver;
        driver = createChrome();
        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver createChrome() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromeDriver/chromedriver.exe");
        return new ChromeDriver();
    }
}
