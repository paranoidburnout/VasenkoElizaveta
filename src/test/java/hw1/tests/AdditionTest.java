package hw1.tests;

import hw1.dataProviders.AdditionDP;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AdditionTest extends AbstractTest {

    @Test(dataProvider = "Addition Data Provider",
            dataProviderClass = AdditionDP.class)
    public void additionTest(int a, int b, int expectedResult) {
        int actualResult = Math.toIntExact(calculator.sum(a, b));
        assertEquals(actualResult, expectedResult);
    }
}
