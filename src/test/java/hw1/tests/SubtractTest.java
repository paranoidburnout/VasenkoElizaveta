package hw1.tests;

import hw1.dataProviders.SubtractionDP;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SubtractTest extends AbstractTest {

    @Test(dataProvider = "Subtraction Data Provider",
            dataProviderClass = SubtractionDP.class)
    public void subtractTest(long a, long b, long expectedResult) {
        long actualResult = calculator.sub(a, b);
        assertEquals(actualResult, expectedResult);
    }
}
