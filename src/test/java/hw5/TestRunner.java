package hw5;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/wh5/features")
public class TestRunner extends AbstractTestNGCucumberTests {
}
