package hw1.tests;

import hw1.dataProviders.MultiplicationDP;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MultiplyTest extends AbstractTest {
    @Test(dataProvider = "Multiplication Data Provider",
            dataProviderClass = MultiplicationDP.class)
    public void multiplyTest(int a, int b, int expectedResult) {
        int actualResult = Math.toIntExact(calculator.mult(a, b));
        assertEquals(actualResult, expectedResult);
    }
}
