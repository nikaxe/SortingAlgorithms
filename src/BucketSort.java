import java.util.LinkedList;
import java.util.ListIterator;

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

        double divider = Math.ceil((m + 1) / (double)k);
        for(int i = 0; i < input.length; i++){
            //int bI = (int)Math.floor(k * input[i] / (double)(m+1));

            double range = input[i] / (double)(m + 1);

            int bI = (int)Math.floor(range * k);

            //System.out.println(range * k + " : " + bI + " " + "(" + i + ")");
            //int bI = (int)Math.floor(input[i] / divider);
            //System.out.println(bI);
            buckets[bI].addFirst(input[i]);
            //System.out.println(Math.floor(k * input[i]));
            //buckets[(int)Math.floor(k * input[i])].addFirst(input[i]);
        }

        // 0 <= a[i] <= m

        // r = input[i] / (m + 1), ger procent utav range
        // floor(r * k) , ger vilken bucket

        // 0 <= a[i] <= k
        for(int i = 0; i < k; i++){
            InsertionSort.sort(buckets[i]);
        }

        int[] res = new int[input.length];
        //for(int i = 0, l = 0; i < k; i++){
        //    for(int j = 0; j < buckets[i].size(); j++, l++){
        //        res[l] = buckets[i].get(j);
        //    }
        //}
        for(int i = 0, j = 0; i < k; i++){
            ListIterator<Integer> it = buckets[i].listIterator(0);
            while(it.hasNext()){
                res[j] = it.next();
                j++;
            }
        }
        return res;
    }

}
