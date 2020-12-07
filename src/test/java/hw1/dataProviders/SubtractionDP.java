package hw1.dataProviders;

import org.testng.annotations.DataProvider;

import static hw1.tests.Const.INT_MAX;
import static hw1.tests.Const.INT_MIN;

public class SubtractionDP {
    @DataProvider(name = "Subtraction Data Provider")
    public Object[][] subtractionDataSet() {
        return new Object[][]{
                {5, 2, 3},
                {70000, 52500, 17500},
                {-69, -0, -69},
                {-1, -1, 0},
                {155210, 14265, 140945},
                {INT_MAX, 0, INT_MAX},
                {INT_MIN, 0, INT_MIN}
        };
    }
}
