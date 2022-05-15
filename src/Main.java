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
            System.out.print(input[i] + " ");
        }
        System.out.print("\n");

        //InsertionSort s = new InsertionSort(); //works
        BucketSort s = new BucketSort(); // doesn't work
        //CountingSort s = new CountingSort(); // works
//        RadixSort s = new RadixSort();
        //int[] output = s.sort(input, 99);
        s.sort2(input);
        for(int i = 0; i < numberOfInput; i++){
            System.out.print(input[i] + " ");
        }
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
