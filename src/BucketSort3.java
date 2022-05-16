import java.util.LinkedList;

public class BucketSort3 {

    public static int[] sort(int[] input) {
//        int k = Math.max(5, input.length / 10);
        int k = input.length;
        LinkedList<Integer>[] buckets = new LinkedList[k];
        for(int i = 0; i < k; i++){
            buckets[i] = new LinkedList<>();
        }
        // find maximum value in the input
        int m = Integer.MIN_VALUE;
        for (int i : input)
            if(i > m) m = i;
        //System.out.println("max " + m);

        for(int i = 0; i < input.length; i++){

            float ratio = (float) input[i] / (m + 1);
            int bucketNumber = (int) (k * ratio);
            buckets[bucketNumber].addFirst(input[i]);


//            double range = input[i] / (double)(m + 1);
//            int bI = (int)Math.floor(range * k);
//            buckets[bI].addFirst(input[i]);
        }


        for (LinkedList<Integer> bucket : buckets) {
            InsertionSort.sort(bucket);
//            Collections.sort(bucket);
        }

//        for(int i = 0; i < k; i++){
//            Collections.sort(buckets[i]);
//            InsertionSort.sort(buckets[i]);
//            buckets[i] = CountingSort.sort(buckets[i]);
//        }

        int[] res = new int[input.length];

        int index = 0;

        for (LinkedList<Integer> bucket : buckets) {
            for (Integer integer : bucket) {
                res[index++] = integer;
            }
        }


//        for(int i = 0, j = 0; i < k; i++){
//            ListIterator<Integer> it = buckets[i].listIterator(0);
//            while(it.hasNext()){
//                res[j] = it.next();
//                j++;
//            }
//        }
//        InsertionSort.sort(res);
//        Arrays.sort(res);
        return res;
    }


}
