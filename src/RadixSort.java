public class RadixSort {
    public static int[] sort(int[] input){
        int maxDigits = countDigits(getMax(input));
        int[] output;

        output = countingSort(input, 0);
        for(int i = 1; i < maxDigits; i++)
            output = countingSort(output, i);
        return output;
    }

    public static int getDigit(int num, int n){
        int count = countDigits(num);
        if(n >= count || n < 0) return 0;
        int[] digits = new int[count];
        for(int i = 0; i < count; i++){
            digits[i] = num % 10;
            num /= 10;
        }
        return digits[n];
    }

    private static int[] countingSort(int[] input, int n){
        int[] count = new int[10];
        int[] output = new int[input.length];
        int i, j;
        for(i = 0; i < input.length; i++){
            j = getDigit(input[i], n);
            count[j] += 1;
        }
        for(i = 1; i <= 9; i++)
            count[i] += count[i - 1];
        for(i = input.length - 1; i >= 0; i--){
            j = getDigit(input[i], n);
            count[j] -= 1;
            output[count[j]] = input[i];
        }
        return output;
    }

    private static int countDigits(int n){
        if(n == 0 || n == 1)
            return 1;
        int digits = 0;
        int checker = 1;
        n = Math.abs(n);
        while(checker <= n){
            digits++;
            checker *= 10;
        }
        return digits;
    }

    private static int getMax(int[] input){
        int max = input[0];
        for(int i = 1; i < input.length; i++){
            if(input[i] > max)
                max = input[i];
        }
        return max;
    }

}
