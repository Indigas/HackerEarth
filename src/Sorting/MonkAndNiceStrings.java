package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MonkAndNiceStrings {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.valueOf(br.readLine());
        String[] arr = new String[testCases+1];

        for(int i = 1; testCases > 0; i++, testCases--){
            arr[i] = br.readLine();
            int result = 0;

            for(int j = i; j > 0; j--){

                if(arr[i].compareTo(arr[j]) > 0)
                    result++;

            }

            System.out.println(result);
        }
    }
}
