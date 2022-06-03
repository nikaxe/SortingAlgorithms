import java.util.Arrays;

public class Lab1 {
    /** Sorting algorithms **/

    // Insertion sort.
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int x = array[i];
            int n = i - 1;
            while (n >= 0 && array[n] > x)
                array[n + 1] = array[n--];
            array[n + 1] = x;
        }
    }

    // Quicksort.
    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    // Quicksort part of an array
    private static void quickSort(int[] array, int begin, int end) {
        if(begin >= end) return;
        int pivot = partition(array, begin, end);
        quickSort(array, begin, pivot - 1);
        quickSort(array, pivot + 1, end);
    }

    // .Partition part of an array, and return the index where the pivot ended up
    private static int partition(int[] array, int begin, int end) {
        int pivot = array[begin];
        int left = begin + 1;
        for (int i = begin + 1; i <= end; i++) {
            if(array[i] < pivot){
                if(i != left)
                    swap(array, i, left);
                left++;
            }
        }
        swap(array, begin, left - 1);
        return left - 1;
    }

    // Swap two elements in an array
    private static void swap(int[] array, int i, int j) {
        int x = array[i];
        array[i] = array[j];
        array[j] = x;
    }

    // Mergesort.
    public static int[] mergeSort(int[] array) {
        if(array.length < 2) return array;
        int midIndex = array.length / 2;
        return merge(
                mergeSort(Arrays.copyOfRange(array, 0, midIndex)),
                mergeSort(Arrays.copyOfRange(array, midIndex, array.length)));
    }

    // Mergesort part of an array
    private static int[] mergeSort(int[] array, int begin, int end) {
        throw new UnsupportedOperationException();
    }

    // Merge two sorted arrays into one
    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];

        for (int i = 0, li = 0, ri = 0; i < result.length; i++) {
            if(li >= left.length){
                result[i] = right[ri++];
                continue;
            }
            else if(ri >= right.length){
                result[i] = left[li++];
                continue;
            }

            if(left[li] < right[ri])
                result[i] = left[li++];
            else
                result[i] = right[ri++];
        }
        return result;
    }
}