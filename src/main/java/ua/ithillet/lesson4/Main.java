package ua.ithillet.lesson4;

public class Main {

    public final static int LENGHT_OF_ARRAY = 4;

    static String[][] array = {{"8", "9", "3", "16"}, {"3", "4", "13", "9"}, {"6", "0", "22", "9"}, {"55", "1", "23", "16"}};

    public static void main(String[] args) {

        ArrayValueCalculator arrayValueCalculator = new ArrayValueCalculator();

            try {
                arrayValueCalculator.doCalc(array);
            } catch (ArraySizeException | ArrayDataException | NumberFormatException ex) {
                ex.printStackTrace();
            }
    }
}
