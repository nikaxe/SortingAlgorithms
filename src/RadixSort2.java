import java.util.Arrays;

public class RadixSort2 {



    public static int[] sort(int[] input) {
        int[] output = input;
        int numDigits = getMaxDigits(input);

        for (int i = 0; i < numDigits; i++) {
            output = radixCountingsort(output, i);
        }

        return output;

    }


    public static int getMaxDigits(int[] input) {
        int max = Integer.MIN_VALUE;

        for (int i : input) {
            if (max < i) max = i;
        }

        return countDigits(max);
    }


    public static int[] radixCountingsort(int[] input, int position) {
        int k = 10;
        int[] count = new int[10];
        int[] output = new int[input.length];

        int i, j;
        for (i = 0; i < input.length; i++) {
            j = getDigit(input[i], position);
            count[j] += 1;
        }
        for (i = 1; i < k; i++) {
            count[i] += count[i - 1];
        }
        for (i = input.length - 1; i >= 0; i--) {
            j = getDigit(input[i], position);
            count[j] -= 1;
            output[count[j]] = input[i];
        }

        return output;
    }


    public static int getDigit(int input, int position) {

        return (int) ( input / Math.pow(10, position) % 10);
    }


    public static int countDigits(int input) {
        int count = 0;
        while (input != 0) {
            input /= 10;
            count++;
        }

        return count;
    }








}
