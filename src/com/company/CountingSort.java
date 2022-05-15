package com.company;

public class CountingSort {

    public int[] sort(int[] input, int k){
        int[] count = new int[k + 1];
        int[] output = new int[input.length];
        int i, j;
        for(i = 0; i < input.length; i++){
            j = input[i];
            count[j] += 1;
        }
        for(i = 1; i <= k; i++){
            count[i] += count[i - 1];
        }
        for(i = input.length - 1; i >= 0; i--){
            j = input[i];
            count[j] -= 1;
            output[count[j]] = input[i];
        }
        return output;
    }

}
