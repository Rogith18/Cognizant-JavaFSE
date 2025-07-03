package demo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import demo.Calculator;


public class CalculatorTest {

    private Calculator calculator;

    // Setup method: runs BEFORE each test
    @Before
    public void setUp() {
        calculator = new Calculator();
        System.out.println("Setup: New calculator created.");
    }

    // Teardown method: runs AFTER each test
    @After
    public void tearDown() {
        calculator = null;
        System.out.println("Teardown: Calculator reset.");
    }

    // Test using Arrange-Act-Assert
    @Test
    public void testAddition() {
        // Arrange
        int a = 4;
        int b = 5;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(9, result);
    }

    @Test
    public void testMultiplication() {
        // Arrange
        int x = 3;
        int y = 6;

        // Act
        int result = calculator.multiply(x, y);

        // Assert
        assertEquals(18, result);
    }

	
}
