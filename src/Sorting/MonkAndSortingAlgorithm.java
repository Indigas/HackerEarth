package Sorting;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class MonkAndSortingAlgorithm {
    private static Map<String, Long> map = new HashMap<>();
    private static int from;
    private static int to;
    private static boolean onlyZeros = false;
    public static void main(String[] args) throws Exception {
        String file = "C:\\Users\\durov\\Downloads\\110bae8ab15d11ea.txt.clean.txt";

        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = Files.newBufferedReader(Paths.get(file));
        int length = Integer.parseInt(br.readLine());

        long startProgram = System.currentTimeMillis();

        String[] arraz = Arrays.stream(br.readLine().split(" ")).toArray(String[]::new);

        br.close();
        String zeros = "00000";

        // chunk
        for(int i = 1; i < 3; i++){
            map.clear();
            from = 5*i;
            to = 1+5*(i-1) - 1;


            for(int j = 0; j < length; j++){
                int fromTemp = arraz[j].length()-from;
                int toTemp = arraz[j].length()-to;

                if(toTemp<=0){
                    map.put(arraz[j], 0L);
                    continue;
                }

                if(fromTemp<0) {
                    fromTemp=0;
                }

                long tmp = Long.parseLong(arraz[j].substring(fromTemp, toTemp));
                map.put(arraz[j], tmp);

                if(onlyZeros)
                    onlyZeros = tmp == 0;

            }


            mergeSort(arraz, 0, arraz.length-1);


            if(onlyZeros)
                break;


            StringBuilder sb = new StringBuilder();
            for(String a : arraz)
                sb.append(a).append(" ");

            System.out.println(sb.toString());

        }

        long endProgram = System.currentTimeMillis();

        System.out.printf("Program runs %d ms", endProgram - startProgram);

    }

    private static void mergeSort(String[] origin, int start, int end){
        if(start < end){

            int mid = (start + end) / 2;
            mergeSort(origin, start, mid);
            mergeSort(origin, mid+1, end);

            merge(origin, start, mid, end);
        }
    }

    private static void merge(String[] origin, int start, int mid, int end){
        String[] temporary = new String[end-start+1];

        int i;
        int midCopy = mid;
        int startCopy = start;
        for(i = 0; i <= (end-startCopy); i++){
            if(start > midCopy){
                temporary[i] = origin[++mid];
                continue;
            }

            if((mid+1) > end){
                temporary[i] = origin[start++];
                continue;
            }

            long first = map.get(origin[start]);
            long second = map.get(origin[mid+1]);

            if(first > second) {
                temporary[i] = origin[mid+1] ;
                mid++;
            } else if(first == second){
                temporary[i] = origin[start++];

            } else {
                temporary[i] = origin[start];
                start++;
            }
        }

        System.arraycopy(temporary,0,origin, startCopy, temporary.length);

    }

}
