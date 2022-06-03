import java.util.*;

public class BucketSort{
    public static int[] sort(int[] input) {
        int k = Math.max(5, input.length / 10);
        //int k = input.length;
        LinkedList<Integer>[] buckets = new LinkedList[k];
        for(int i = 0; i < k; i++){
            buckets[i] = new LinkedList<Integer>();
        }
        // find maximum value in the input
        int m = Integer.MIN_VALUE;
        for (int i : input)
            if(i > m) m = i;

        //double m1 = m + 1;
        for(int i = 0; i < input.length; i++){
            int testI = (int)Math.floor(k * (input[i] / (double)(m + 1)));
            buckets[testI].addFirst(input[i]);
        }

        for(int i = 0; i < k; i++){
            InsertionSort.sort(buckets[i]);
        }

        int[] res = new int[input.length];
        for(int i = 0, j = 0; i < k; i++){
            for(int l = 0; l < buckets[i].size(); l++, j++){
                res[j] = buckets[i].get(l);
            }
        }
        return res;
    }
}
