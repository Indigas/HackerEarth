package Searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class WetClothes {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] firstLine = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] n = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] m = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int maxDifference = 0;

        for(int i = 0; i < (n.length-1); i++){
            int diff = n[i+1] - n[i];

            if(maxDifference < diff)
                maxDifference = diff;
        }

        int count=0;
        for (int timeToDry : m) {
            if(maxDifference >= timeToDry)
                count++;
        }

        System.out.println(count);
    }
}
