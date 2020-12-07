package hw1.dataProviders;

import org.testng.annotations.DataProvider;

import static hw1.tests.Const.INT_MAX;
import static hw1.tests.Const.INT_MIN;

public class AdditionDP {
    @DataProvider(name = "Addition Data Provider")
    public Object[][] subtractionDataSet() {
        return new Object[][]{
                {2, 2, 4},
                {18000, 52000, 70000},
                {25, 5, 30},
                {-1, 1, 0},
                {-1, -1, -2},
                {INT_MAX, INT_MIN, -1},
                {INT_MIN, 1, -2147483647},
                {0, 0, 0}
        };
    }
}
