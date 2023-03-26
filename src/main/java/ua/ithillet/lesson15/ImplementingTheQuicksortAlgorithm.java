package ua.ithillet.lesson15;

public class ImplementingTheQuicksortAlgorithm {

        public static void sort(int[] arr) {
            quicksort(arr, 0, arr.length - 1);
        }

        private static void quicksort(int[] arr, int left, int right) {
            if (left >= right) {
                return;
            }
            int baseIndex = partitioningAnArray(arr, left, right);
            quicksort(arr, left, baseIndex - 1);
            quicksort(arr, baseIndex + 1, right);
        }

        private static int partitioningAnArray(int[] arr, int left, int right) {
            int base = arr[left];
            int i = left;
            int j = right;
            while (i < j) {
                while (i < j && arr[j] >= base) {
                    j--;
                }
                arr[i] = arr[j];
                while (i < j && arr[i] < base) {
                    i++;
                }
                arr[j] = arr[i];
            }
            arr[i] = base;
            return i;
        }

}
