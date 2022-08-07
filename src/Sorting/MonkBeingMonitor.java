package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MonkBeingMonitor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        for( ; testCases > 0; testCases--){
            int noOfStudents = Integer.parseInt(br.readLine());
            String[] heightsString = br.readLine().split(" ");
            int[] heights = Arrays.stream(heightsString).mapToInt(Integer::parseInt).toArray();

            Map<Integer, Integer> map = new TreeMap<>();
            for(int i=0; i < noOfStudents; i++){
                int students = 1;
                if(map.containsKey(heights[i]))
                    students += map.get(heights[i]);

                map.put(heights[i], students);
            }

            int[] students = map.keySet().stream().mapToInt(Integer::intValue).toArray();
            int maxDiff = 0;
            for(int i = students.length-1; i > 1 ; i--){
                if(map.get(students[i]) <= (1+maxDiff))
                    continue;

                for(int j = i-1; j >= 0; j--){
                    int h1 = students[i];
                    int h2 = students[j];

                    int diff = map.get(h1) - map.get(h2);
                    if(diff > 0 && maxDiff < diff){
                        maxDiff = diff;
                    }
                }
            }

            System.out.println(maxDiff==0 ? -1 : maxDiff);
        }
    }
}
