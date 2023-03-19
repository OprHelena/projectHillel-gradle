package ua.ithillet.lesson13;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.ForkJoinPool;

public class SimpleCalculatorTest {

    @Test
    public void checkSquareSumMethod() {
        SimpleCalculator simpleCalculator = new SimpleCalculator();
        Assertions.assertEquals(13, simpleCalculator.squareSum(2, 3));
    }


//    @Test
//
//    public void checkWorkOfThread() {
//        NewArrayInitializer newArrayInitializer = new NewArrayInitializer();
//        double[] array = new double[20];
//        newArrayInitializer.filInArray(2.5, array);
//        newArrayInitializer.init(array);
//
//            for (int i = 0; i < array.length / 2; i++) {
//                Assertions.assertEquals(array[i], array[array.length / 2 + i]);
//            }
//        }
}
