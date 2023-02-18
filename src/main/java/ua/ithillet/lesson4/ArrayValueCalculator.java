package ua.ithillet.lesson4;

import static ua.ithillet.lesson4.Main.LENGHT_OF_ARRAY;

public class ArrayValueCalculator {

    public int doCalc(String[][] array) {
        int sum = 0;
        if (LENGHT_OF_ARRAY != array.length) {
            throw new ArraySizeException("Incorrect size of array. Array should has size " + LENGHT_OF_ARRAY + ". But now: " + array.length);
        }
        for (int i = 0; i < LENGHT_OF_ARRAY; i++) {
            if (array[i].length != LENGHT_OF_ARRAY) {
                throw new ArraySizeException("Lenght of row is not correct. Index of row " + i + " length of row " + array[i].length);
            }
            for (int j = 0; j < LENGHT_OF_ARRAY; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException ex) {
                    throw new ArrayDataException("Is not a number type or empty cell by index: array[" + i + "][" + j + "]");
                }
            }
        }
        System.out.print("Sum of all value of array cells is : " + sum);
        return sum;
    }

}
