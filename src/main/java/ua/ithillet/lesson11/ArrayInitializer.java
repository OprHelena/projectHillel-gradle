package ua.ithillet.lesson11;

import java.util.Arrays;

public class ArrayInitializer {

    public void init(double[] array) {

        double[] firstPartOfArray = Arrays.copyOfRange(array, 0, array.length / 2);
        double[] secondPartOfArray = Arrays.copyOfRange(array, array.length / 2, array.length);

        Thread thread1 = new Thread(new runAndCalculateArrayInitializer(firstPartOfArray), "thread1");
        Thread thread2 = new Thread(new runAndCalculateArrayInitializer(secondPartOfArray), "thread2");

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.arraycopy(firstPartOfArray, 0, array, 0, firstPartOfArray.length);
        System.arraycopy(secondPartOfArray, 0, array, array.length / 2, secondPartOfArray.length);
    }

    private record runAndCalculateArrayInitializer(double[] array) implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < array.length; i++) {
                array[i] = (array[i] * Math.sin(0.2 + i / 5.0) * Math.cos(0.2 + i / 5.0) * Math.cos(0.4 + i / 2.0));
            }
        }
    }

    public double[] filInArray(double value, double[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = value;
        }
        return array;
    }
}
