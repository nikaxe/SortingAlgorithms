package deprecated;

import java.util.*;
import java.util.Collections;


public class BucketSort2 {











    public static int[] sort(int[] input) {



        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int[] output = new int[input.length];


        for (int i : input) {
            if (i < min) {
                min = i;
            }
            if (i > max) {
                max = i;
            }
        }

        int size = max - min + 1;

        List<Integer>[] pigeonholes = new ArrayList[size];


        for (int i = 0; i < pigeonholes.length; i++)
        {
            pigeonholes[i] = new ArrayList<>();
        }


//        for (List<Integer> pigeonhole : pigeonholes) {
//            System.out.println(pigeonhole);
//        }

        for (int i : input) {
//            System.out.println(i);
            pigeonholes[i - min].add(i);
        }

        int k = 0;

        for (List<Integer> pigeonhole : pigeonholes) {
            for (Integer integer : pigeonhole) {
                output[k++] = integer;
            }
        }

        return output;
    }

/*        // Function to sort arr[] of size n
        // using bucket sort
        static void bucketSort2(float[] arr, int n)
        {
            if (n <= 0)
                return;

            // 1) Create n empty buckets
            @SuppressWarnings("unchecked")
            Vector<Float>[] buckets = new Vector[n];

            for (int i = 0; i < n; i++) {
                buckets[i] = new Vector<Float>();
            }

            // 2) Put array elements in different buckets
            for (int i = 0; i < n; i++) {
                float idx = arr[i] * n;
                buckets[(int)idx].add(arr[i]);
            }

            // 3) Sort individual buckets
            for (int i = 0; i < n; i++) {
                Collections.sort(buckets[i]);
            }

            // 4) Concatenate all buckets into arr[]
            int index = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < buckets[i].size(); j++) {
                    arr[index++] = buckets[i].get(j);
                }
            }

//            return arr;
        }*/
    }

// This code is contributed by Himangshu Shekhar Jha




