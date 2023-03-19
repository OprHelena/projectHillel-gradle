package ua.ithillet.lesson13;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;


public class NewArrayInitializer {

    public void init(double[] array) {
        ForkJoinPool pool = new ForkJoinPool(2);
        pool.invoke(new ArrayInitializerTask(array, 0, array.length));
    }

    static class ArrayInitializerTask extends RecursiveAction {

        private final double[] array;
        private final int start;
        private final int end;

        ArrayInitializerTask(double[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {
            if (end - start <= 10) {
                for (int i = start; i < end; i++) {
                    array[i] = (array[i] * Math.sin(0.2 + i / 5.0) * Math.cos(0.2 + i / 5.0) * Math.cos(0.4 + i / 2.0));
                }
            } else {
                int mid = (start + end) / 2;
                ArrayInitializerTask left = new ArrayInitializerTask(array, start, start + (end - start) / 2);
                ArrayInitializerTask right = new ArrayInitializerTask(array, start + (end - start) / 2, end);
                invokeAll(left, right);
            }
        }
    }

    public double[] filInArray(double value, double[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = value;
        }
        return array;
    }

    public boolean isContainsValue(double[] values, double target) {
        return Arrays.stream(values).anyMatch(i -> i==target);
    }
}
