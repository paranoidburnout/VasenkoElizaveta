package hw1.tests;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class AbstractTest {

    protected Calculator calculator;

    @BeforeTest
    public void setUp() {
        this.calculator = new Calculator();
    }

    @AfterTest
    private void TearUp() {
        calculator = null;
    }
}
