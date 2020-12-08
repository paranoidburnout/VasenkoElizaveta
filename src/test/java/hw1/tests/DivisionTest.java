package hw1.tests;

import hw1.dataProviders.DivisionDP;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DivisionTest extends AbstractTest {

    @Test(dataProvider = "Division Data Provider",
            dataProviderClass = DivisionDP.class)
    public void divideTest(int a, int b, int expectedResult) {
        int actualResult = Math.toIntExact(calculator.div(a, b));
        assertEquals(actualResult, expectedResult);
    }

    @Test(dataProvider = "Divide By Zero",
            dataProviderClass = DivisionDP.class,
            expectedExceptions = NumberFormatException.class,
            expectedExceptionsMessageRegExp = "Attempt to divide by zero")
    public void divideByZeroTest(int a, int b) {
        calculator.div(a, b);
    }
}
