package ua.ithillet.lesson15;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ImplementingTheQuicksortAlgorithmTest {

    private static int[] array = {7, 85, 9, 0, 1, 63, 215, 2, 33, 15};
    private static int[] target = {0, 1, 2, 7, 9, 15, 33, 63, 85, 215};

    @Test
    public void checkQuicksortMethod() {
        ImplementingTheQuicksortAlgorithm.sort(array);
        Assertions.assertArrayEquals(array, target);
        Assertions.assertEquals(array[0], target[0]);
        Assertions.assertEquals(array[6], target[6]);
    }
}
