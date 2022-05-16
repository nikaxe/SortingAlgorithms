import java.util.Arrays;

public class Driver {

    public static void main(String[] args) {


//        int testInput = 57648;

//        int testOutput = RadixSort2.countDigits(testInput);

//        System.out.println(testOutput);

//        int testOutput = RadixSort2.getDigit(testInput, 3);

//        System.out.println(testOutput);


        int[] testArray = new int[]{13, 56, 45, 78, 81, 105};



//        int[] testArrayOutput = RadixSort2.radixCountingsort(testArray, 0);
//
//        System.out.println(Arrays.toString(testArrayOutput));
//
//
//        int[] output2 = RadixSort2.radixCountingsort(testArrayOutput, 1);
//
//        System.out.println(Arrays.toString(output2));
//
//
//        System.out.println(RadixSort2.getMaxDigits(testArrayOutput));



        int[] testArrayOutput = PigeonHoleSort2.sort(testArray);

        System.out.println(Arrays.toString(testArrayOutput));





    }
}
