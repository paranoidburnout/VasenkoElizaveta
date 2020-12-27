package hw3;

import hw3.pages.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class GeneralTests {

    protected WebDriver driver;
    protected HomePage homePage;


    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // 1. Open test site by URL
        homePage = new HomePage(driver);
        homePage.openHomePage();
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }

}
