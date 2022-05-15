import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BucketSort{

    InsertionSort is = new InsertionSort();



    public int[] sort2(int[] input) {

        int k = input.length / 20;
        int[] output = new int[input.length];


        List<LinkedList<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            buckets.add(new LinkedList<>());
        }

        for (int i : input) {
            int bucketDestination = i % k;
            buckets.get(bucketDestination).add(i);
        }

        for (LinkedList<Integer> bucket : buckets) {
            is.sort(bucket);
        }

        int index = 0;

        for (LinkedList<Integer> bucket : buckets) {
            for (Integer integer : bucket) {
                output[index] = integer;
            }
        }

        return output;
    }





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







//        int min = Integer.MAX_VALUE;
//        int max = Integer.MIN_VALUE;
//
//        for (int i : input) {
//            if (i < min) {
//                min = i;
//            }
//            if (i > max) {
//                max = i;
//            }
//        }




//        LinkedList<Integer>[] buckets = new LinkedList[input.length];



