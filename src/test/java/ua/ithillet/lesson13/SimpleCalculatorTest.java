package ua.ithillet.lesson13;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimpleCalculatorTest {

    @Test
    public void checkSquareSumMethod() {
        SimpleCalculator simpleCalculator = new SimpleCalculator();
        Assertions.assertEquals(13, simpleCalculator.squareSum(2, 3));
    }


    @Test

    public void checkWorkOfThread() {
        NewArrayInitializer newArrayInitializer = new NewArrayInitializer();
        double[] array = new double[20];
        newArrayInitializer.filInArray(2.5, array);
        newArrayInitializer.init(array);

        Assertions.assertFalse(newArrayInitializer.isContainsValue(array, 2.5));
    }
}
