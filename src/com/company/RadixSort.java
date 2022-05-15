package com.company;

public class RadixSort {
    public int[] sort(int[] input){
        int[] output = new int[input.length];
        int maxDigits = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < input.length; i++){
            maxDigits = Math.max(maxDigits, countDigits(input[i]));
            max = Math.max(max, input[i]);
        }
        System.out.println(maxDigits);

        for(int i = 0; i < maxDigits; i++){
            countingSort(input, output, max, i);
        }

        return output;
    }

    private int getDigit(int num, int n){
        int count = countDigits(num);
        if(n > count)
            return 0;
        int[] digits = new int[count];
        for(int i = 10; i < (int)Math.round(Math.pow(10, n)); i*=10){
            digits[(int)Math.log10(i)] = num / i;
        }
        digits[0] = num % 10;
        return digits[n];
    }

    private void countingSort(int[] input, int[] output, int k, int n){
        int[] count = new int[k + 1];
        int i, j;
        for(i = 0; i < input.length; i++){
            j = getDigit(input[i], n+1);
            count[j] += 1;
        }
        for(i = 1; i <= k; i++){
            count[i] += count[i - 1];
        }
        for(i = input.length - 1; i >= 0; i--){
            j = getDigit(input[i], n+1);
            count[j] -= 1;
            output[count[j]] = input[i];
        }
    }

    private int countDigits(int n){
        if(n == 0)
            return 1;
        int digits = 1;
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
