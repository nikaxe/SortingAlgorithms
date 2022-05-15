package com.company;

import java.util.LinkedList;

public class BucketSort{

    InsertionSort is = new InsertionSort();

    public int[] sort(int[] input, int k) {
        LinkedList<Integer>[] buckets = new LinkedList[k];
        for(int i = 0; i < k; i++){
            buckets[i] = new LinkedList<Integer>();
        }
        // find maximum value in the input
        int m = Integer.MIN_VALUE;
        for (int i : input)
            if(i > m) m = i;

        for(int i = 0; i < input.length; i++){
            int bI = clamp((int)Math.floor(k * input[i] / m), 0, k - 1);
            System.out.println(bI);
            buckets[bI].addFirst(input[i]);
            //System.out.println(Math.floor(k * input[i]));
            //buckets[(int)Math.floor(k * input[i])].addFirst(input[i]);
        }

        for(int i = 0; i < k; i++){
            is.sort(buckets[i]);
        }

        int[] res = new int[input.length];
        for(int i = 0, j = 0; i < k; i++){
            for(int l = 0; l < buckets[k].size(); l++, j++){
                res[j] = buckets[i].get(l);
            }
        }

        return res;
    }

    public int clamp(int value, int one, int two){
        if(value < one)
            return one;
        if(value > two)
            return two;
        return value;
    }
}
