package hw1.dataProviders;

import org.testng.annotations.DataProvider;

import static hw1.tests.Const.INT_MAX;
import static hw1.tests.Const.INT_MIN;

public class DivisionDP {
    @DataProvider(name = "Division Data Provider")
    public Object[][] subtractionDataSet() {
        return new Object[][]{
                {25,5,5},
                {555,5,111},
                {30000,12,2500},
                {840000,12,70000},
                {1,1,1},
                {0, INT_MIN, 0},
                {0, INT_MAX, 0}
        };
    }

    @DataProvider(name = "Divide By Zero")
    public Object[][] divideByZeroDP() {
        return new Object[][]{
                {0, 0},
                {INT_MIN, 0},
                {INT_MAX, 0},
        };
    }
}
