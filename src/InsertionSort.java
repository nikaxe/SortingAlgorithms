import java.util.List;

public class InsertionSort {

    public int[] sort(int[] input) {
        int i = 1;
        int x;
        int j;
        while(i < input.length){
            x = input[i];
            j = i - 1;
            while(j >= 0 && input[j] > x){
                input[j + 1] = input[j];
                j--;
            }
            input[j + 1] = x;
            i++;
        }
        return input;
    }

    public static void sort(List<Integer> input){
        int i = 1;
        int x;
        int j;
        while(i < input.size()){
            x = input.get(i);
            j = i - 1;
            while(j >= 0 && input.get(j) > x){
                input.set(j + 1, input.get(j));
                j--;
            }
            input.set(j + 1, x);
            i++;
        }
    }

}
