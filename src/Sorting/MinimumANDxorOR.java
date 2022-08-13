package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MinimumANDxorOR {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        for(; testCases > 0; testCases--){
            int lengthArray = Integer.parseInt(br.readLine());

            int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            Arrays.sort(array);

            int min = array[0] ^ array[1];
            for(int i = 1; i < (lengthArray-1); i++){
                int temp = array[i] ^ array[i+1];
                if(temp < min)
                    min = temp;
            }

            System.out.println(min);
        }
    }
}
