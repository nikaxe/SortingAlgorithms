import java.util.*;

public class BucketSort{
    public static int[] sort(int[] input) {
        int k = Math.max(5, input.length / 20);
        LinkedList<Integer>[] buckets = new LinkedList[k];
        for(int i = 0; i < k; i++){
            buckets[i] = new LinkedList<Integer>();
        }
        // find maximum value in the input
        int m = Integer.MIN_VALUE;
        for (int i : input)
            if(i > m) m = i;
        //System.out.println("max " + m);

        for(int i = 0; i < input.length; i++){
            double range = input[i] / (double)(m + 1);
            int bI = (int)Math.floor(range * k);
            buckets[bI].addFirst(input[i]);
        }

        //for(int i = 0; i < k; i++){
        //    InsertionSort.sort(buckets[i]);
        //    //buckets[i] = CountingSort.sort(buckets[i]);
        //}

        int[] res = new int[input.length];
        for(int i = 0, j = 0; i < k; i++){
            ListIterator<Integer> it = buckets[i].listIterator(0);
            while(it.hasNext()){
                res[j] = it.next();
                j++;
            }
        }
        //InsertionSort.sort(res);
        Arrays.sort(res);
        return res;
    }


    public static int[] sort2(int[] input) {


        if (input.length < 30) {
            return InsertionSort.sort(input);
        }


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
            InsertionSort.sort(bucket);
        }

        int index = 0;

        for (LinkedList<Integer> bucket : buckets) {
            for (Integer integer : bucket) {
                output[index] = integer;
                index++;
            }
        }

        return output;
    }

    public static int[] sort3(int[] input){
        // kod för hur många buckets
        int n = input.length;
        int nB = Math.max(5, input.length / 2);
        int m = 0;
        Vector<Integer>[] buckets = new Vector[n];
        for (int i = 0; i < nB; i++) {
            buckets[i] = new Vector<Integer>();
        }
        for (int i = 0; i < n; i++) {
            if(input[i] > m) m = input[i];
        }
        for (int i = 0; i < n; i++) {
            float idx = (input[i] / (float)(m + 1)) * nB;
            buckets[(int)idx].add(input[i]);
        } // n^2 / (n / 2) == n^2 * (2 / n)
        for (int i = 0; i < nB; i++) {
            //Collections.sort(buckets[i]);
            //buckets[i] = sort(buckets[i]);
            InsertionSort.sort(buckets[i]);
        }
        int index = 0;
        for (int i = 0; i < nB; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                input[index++] = buckets[i].get(j);
            }
        }
        return input;
    }

    public static Vector<Integer> sort(Vector<Integer> input){
        int k = 0;
        for(int i = 0; i < input.size(); i++)
            if(k < input.get(i)) k = input.get(i);

        int[] count = new int[k + 1];
        Vector<Integer> output = new Vector<Integer>();
        for(int i = 0; i < input.size(); i++)
            output.addElement(0);
        int i, j;
        for(i = 0; i < input.size(); i++){
            j = input.get(i);
            count[j] += 1;
        }
        for(i = 1; i <= k; i++)
            count[i] += count[i - 1];
        for(i = input.size() - 1; i >= 0; i--){
            j = input.get(i);
            count[j] -= 1;
            output.set(count[j], input.get(i));
        }
        return output;
    }

}
