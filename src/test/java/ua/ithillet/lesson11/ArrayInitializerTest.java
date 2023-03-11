package ua.ithillet.lesson11;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayInitializerTest {
    ArrayInitializer arrayInitializer = new ArrayInitializer();
    double[] array = new double[20];

    @Test
    public void checkWorkOfThread() {

        arrayInitializer.filInArray(10.05, array);
        arrayInitializer.init(array);

        for (int i = 0; i < array.length / 2; i++) {
            Assertions.assertEquals(array[i], array[array.length / 2 + i]);
        }
    }

}
