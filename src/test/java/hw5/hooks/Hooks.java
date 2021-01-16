package hw5.hooks;

import hw5.driver.WebDriverSingleton;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    @Before
    public void setUp() {
        WebDriverSingleton.getDriver();
    }

    @After
    public void tearDown() {
        WebDriverSingleton.closeDriver();
    }
}
