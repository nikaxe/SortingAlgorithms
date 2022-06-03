public class RadixSort3 {
    // Returns the maximum value in an int array.
    public static int getMax(int input[]) {
        int max = input[0];
        for (int i = 1; i < input.length; i++) {
            if (input[i] > max)
                max = input[i];
        }
        return max;
    }

    // Radix sort
    public static int[] sort(int input[]) {
        int digit = 1;
        int n = input.length;
        int result[] = new int[n];
        int max = getMax(input);

        while (max / digit > 0) {
            // Create the count array
            int count[] = new int[10];
            for (int i = 0; i < 10; i++)
                count[i] = 0;

            // Populate the count array
            for (int i = 0; i < n; i++)
                count[(input[i] / digit) % 10]++;

            // Accumulate count array
            for (int i = 1; i < 10; i++)
                count[i] += count[i - 1];

            // Fill result array, guided by the count array
            for (int i = n - 1; i >= 0; i--) {
                result[count[(input[i] / digit) % 10] - 1] = input[i];
                count[(input[i] / digit) % 10]--;
            }

            // Reorder original array
            for (int i = 0; i < n; i++)
                input[i] = result[i];

            digit *= 10;
        }

        return input;
    }

}
