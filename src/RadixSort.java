public class RadixSort {
    public int[] sort(int[] input){
        int[] output = new int[input.length];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < input.length; i++)
            if(max < input[i]) max = input[i];

        int maxDigits = countDigits(max);
        boolean returnInput = true;
        for(int i = 0; i < maxDigits; i++){
            returnInput = !returnInput;
            if(returnInput) {
                countingSort(output, input, 9, i);
                for(int j = 0; j < input.length; j++){
                    System.out.print(input[j] + " ");
                }
                System.out.print("\n");
            }
            else {
                countingSort(input, output, 9, i);
                for(int j = 0; j < input.length; j++){
                    System.out.print(output[j] + " ");
                }
                System.out.print("\n");
            }
        }
        if(returnInput)
            return input;
        return output;
    }

    public int getDigit(int num, int n){
        int count = countDigits(num);
        if(n >= count || n < 0) return 0;
        int[] digits = new int[count];
        for(int i = 0; i < count; i++){
            digits[i] = num % 10;
            num /= 10;
        }
        return digits[n];
    }

    private void countingSort(int[] input, int[] output, int k, int n){
        int[] count = new int[k + 1];
        int i, j;
        for(i = 0; i < input.length; i++){
            j = getDigit(input[i], n);
            count[j] += 1;
        }
        for(i = 1; i <= k; i++){
            count[i] += count[i - 1];
        }
        for(i = input.length - 1; i >= 0; i--){
            j = getDigit(input[i], n);
            count[j] -= 1;
            output[count[j]] = input[i];
        }
    }

    public int countDigits(int n){
        if(n == 0 || n == 1)
            return 1;
        int digits = 0;
        int checker = 1;
        n = Math.abs(n);
        while(checker < n){
            digits++;
            checker *= 10;
        }
        return digits;
    }

    public void sort2(int[] input){
        int digitPlace = 1;
        int n = input.length;
        int[] result = new int[n];
        int largestNum = getMax(input);
        while(largestNum / digitPlace > 0){
            int[] count = new int[10]; // 10 since 0-9 is ten digits
            for(int i = 0; i < n; i++)
                count[(input[i] / digitPlace)]++;
            for(int i = 1; i < 10; i++)
                count[i] += count[i - 1];
            for(int i = n - 1; i >= 0; i--){
                result[count[(input[i] / digitPlace) % 10]] = input[i];
                count[(input[i] / digitPlace) % 10]--;
            }
            for(int i = 0; i < n; i++){
                input[i] = result[i];
                digitPlace *= 10;
            }

        }
    }

    private int getMax(int[] input){
        int max = input[0];
        for(int i = 1; i < input.length; i++){
            if(input[i] > max)
                max = input[i];
        }
        return max;
    }

}
