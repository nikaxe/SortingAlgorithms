import java.util.Arrays;

public class PigeonHoleSort {
    public static int[] sort(int[] input){
        int n = input.length;
        int min = input[0];
        int max = input[0];
        int range, i, j, index;

        for(int a = 0; a < n; a++)
        {
            if(input[a] > max)
                max = input[a];
            if(input[a] < min)
                min = input[a];
        }

        range = max - min + 1;
        int[] phole = new int[range];
        Arrays.fill(phole, 0);

        for(i = 0; i < n; i++)
            phole[input[i] - min]++;


        index = 0;

        for(j = 0; j < range; j++)
            while(phole[j]-- > 0)
                input[index++] = j + min;
        return input;
    }
}
