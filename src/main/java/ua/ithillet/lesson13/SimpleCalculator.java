package ua.ithillet.lesson13;

import java.util.concurrent.CompletableFuture;

public class SimpleCalculator {

        public int squareSum(int first, int second) {
            CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
                return first * first;
            });

            CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
                return second * second;
            });

            return future1.thenCombine(future2, Integer::sum).join();
        }
}
