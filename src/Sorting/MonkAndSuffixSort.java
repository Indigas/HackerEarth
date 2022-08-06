package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class MonkAndSuffixSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();

        String[] input = name.split(" ");
        String[] arr = new String[input[0].length()];

        for(int i = 0; i < input[0].length(); i++){

            arr[i] = input[0].substring(i, input[0].length());

        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return s.compareTo(t1);
            }
        });

        System.out.println(arr[Integer.parseInt(input[1])-1]);

    }
}
