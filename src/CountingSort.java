import java.util.LinkedList;
import java.util.List;

public class CountingSort {
    public static int[] sort(int[] input){
        int k = 0;
        for(int i = 0; i < input.length; i++){
            if(k < input[i]) k = input[i];
        }

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

    public static List<Integer> sort(List<Integer> input){
        int k = 0;
        for(int i = 0; i < input.size(); i++)
            if(k < input.get(i)) k = input.get(i);

        int[] count = new int[k + 1];
        List<Integer> output = new LinkedList<Integer>();
        for(int i = 0; i < input.size(); i++)
            output.add(0);
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
