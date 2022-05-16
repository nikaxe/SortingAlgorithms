import java.util.ArrayList;
import java.util.List;

public class PigeonHoleSort2 {


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


        for (int i = 0; i < pigeonholes.length; i++) {
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


    // testing
}