package hw1.dataProviders;

import org.testng.annotations.DataProvider;

import static java.lang.Long.MAX_VALUE;
import static java.lang.Long.MIN_VALUE;

public class SubtractionDP {

    @DataProvider(name = "Subtraction Data Provider")
    public Object[][] subtractionDataSet() {
        return new Object[][]{
                {5, 2, 3},
                {70000, 52500, 17500},
                {-69, -0, -69},
                {-1, -1, 0},
                {155210, 14265, 140945},
                {MAX_VALUE, 0, MAX_VALUE},
                {MIN_VALUE, 0, MIN_VALUE}
        };
    }
}
