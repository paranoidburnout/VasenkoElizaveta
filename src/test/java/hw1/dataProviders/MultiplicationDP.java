package hw1.dataProviders;

import org.testng.annotations.DataProvider;

import static hw1.tests.Const.INT_MAX;
import static hw1.tests.Const.INT_MIN;

public class MultiplicationDP {
    @DataProvider(name = "Multiplication Data Provider")
    public Object[][] subtractionDataSet() {
        return new Object[][]{
                {760,6,4560},
                {760,12,9120},
                {0, INT_MIN, 0},
                {INT_MAX, 0, 0},
                {1400,6,8400},
                {1400,4,5600},
                {2500,12,30000}
        };
    }
}
