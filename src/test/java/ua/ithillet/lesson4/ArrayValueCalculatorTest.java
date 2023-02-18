package ua.ithillet.lesson4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArrayValueCalculatorTest {

    ArrayValueCalculator arrayValueCalculator = new ArrayValueCalculator();

    private final String[][] array1 = {{"8", "9", "3", "16"}, {"3", "4", "13", "9"}, {"6", "0", "22", "4"}, {"55", "1", "23", "16"}};
    private final String[][] array2 = {{"8", "9", "3", "0"}, {"3", "4", "-15", "9"}, {"-66", "0", "22", "4"}, {"-155", "1", "23", "16"}};
    private final String[][] array3 = {{"8", "9", "3", "7"}, {"3", "4", "-15", "88"}, {"-66", "0", "22", "99"}, {"6", "0", "22", "4"}, {"7", "8", "8", "9"}};
    private final String[][] array4 = {{"8", "9", "3", "7"}, {"3", "4", "-15", "88"}, {"-66", "0", "22", "99"}};
    private final String[][] array5 = {{"8", "9", "3", "7"}, {"3", "4", "9", "-15"}, {"-66", "0", "22", "99", "88", "77"}, {"-66", "0", "22", "99"}};
    private final String[][] array6 = {{"8", "9", "3", "16"}, {"3", "4", "13", "9"}, {"6", "0", "B", "4"}, {"55", "1", "23", "16"}};

    @Test
    public void CheckTheSumOfCellsValueInArray() {
        assertEquals(192, arrayValueCalculator.doCalc(array1), " The sum of cells value is not correct");
    }

    @Test
    public void checkTheSumWithNegativeOrZeroValue() {
        assertEquals(-134, arrayValueCalculator.doCalc(array2), " The sum of cells value is not correct");
    }

    @Test
    public void testThatTheNumberOfRowInArrayToBig() {
        assertThrows(ArraySizeException.class, () -> arrayValueCalculator.doCalc(array3));
    }

    @Test
    public void testThatTheNumberOfRowInArrayToSmall() {
        assertThrows(ArraySizeException.class, () -> arrayValueCalculator.doCalc(array4));
    }

    @Test
    public void testThatTheNumberOfCellsInArrayIsWrong() {
        assertThrows(ArraySizeException.class, () -> arrayValueCalculator.doCalc(array5));
    }

    @Test
    void testThatTheValueOfCellIsNotANumber() {
        assertThrows(ArrayDataException.class, () -> arrayValueCalculator.doCalc(array6));
    }
}
