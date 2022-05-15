import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int numberOfInput = 100;
	    int[] input = new int[numberOfInput];
        for(int i = 0; i < numberOfInput; i++){
            input[i] = i;
        }
        shuffle(input);
        for(int i = 0; i < numberOfInput; i++){
            System.out.print(input[i] + "(" + i + ")" + " ");
        }
        System.out.print("\n");

        //int[] output = s.sort(input, 99);
        int[] output = RadixSort.sort(input);
        //for(int i = 0; i < numberOfInput; i++){
        //    System.out.print(output[i] + " ");
        //}
        System.out.print("\n");

    }

    public static void shuffle(int[] input){
        Random random = new Random();
        for(int i = input.length - 1; i > 0; i--){
            int j = random.nextInt(i + 1);
            int temp = input[i];
            input[i] = input[j];
            input[j] = temp;
        }
    }
}
