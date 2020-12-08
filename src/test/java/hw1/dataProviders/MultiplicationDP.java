package hw1.dataProviders;

import org.testng.annotations.DataProvider;

import static java.lang.Long.MAX_VALUE;
import static java.lang.Long.MIN_VALUE;

public class MultiplicationDP {

    @DataProvider(name = "Multiplication Data Provider")
    public Object[][] subtractionDataSet() {
        return new Object[][]{
                {760, 6, 4560},
                {760, 12, 9120},
                {0, MIN_VALUE, 0},
                {MAX_VALUE, 0, 0},
                {1400, 6, 8400},
                {1400, 4, 5600},
                {2500, 12, 30000}
        };
    }
}
