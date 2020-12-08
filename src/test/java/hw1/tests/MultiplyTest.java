package hw1.tests;

import hw1.dataProviders.MultiplicationDP;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MultiplyTest extends AbstractTest {

    @Test(dataProvider = "Multiplication Data Provider",
            dataProviderClass = MultiplicationDP.class)
    public void multiplyTest(long a, long b, long expectedResult) {
        long actualResult = calculator.mult(a, b);
        assertEquals(actualResult, expectedResult);
    }
}
