package hw1.dataProviders;

import org.testng.annotations.DataProvider;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;

public class AdditionDP {

    @DataProvider(name = "Addition Data Provider")
    public Object[][] subtractionDataSet() {
        return new Object[][]{
                {2, 2, 4},
                {18000, 52000, 70000},
                {25, 5, 30},
                {-1, 1, 0},
                {-1, -1, -2},
                {MAX_VALUE, MIN_VALUE, -1},
                {MIN_VALUE, 1, -2147483647},
                {0, 0, 0}
        };
    }
}
