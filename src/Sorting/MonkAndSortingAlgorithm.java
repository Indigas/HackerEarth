package Sorting;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MonkAndSortingAlgorithm {
    private static Map<String, String> map = new HashMap<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());

        String[] arraz = Arrays.stream(br.readLine().split(" ")).toArray(String[]::new);
        String[] copyOfOrigin = Arrays.copyOf(arraz, arraz.length);
        String[] chunk = new String[length];
        String zeros = "00000";
        boolean onlyZeros = false;

        // chunk
        for(int i = 1; ; i++){
            onlyZeros = true;
            int from = 5*i;
            int to = 1+5*(i-1) - 1;

            for(int j = 0; j < length; j++){
                int fromTemp = arraz[j].length()-from;
                int toTemp = arraz[j].length()-to;

                if(toTemp<=0){
                    //chunk[j] = zeros;
                    map.put(arraz[j], zeros);
                    continue;
                }

                if(fromTemp>-1) {
                    //chunk[j] = arraz[j].substring(fromTemp, toTemp);
                    map.put(arraz[j], arraz[j].substring(fromTemp, toTemp));
                    onlyZeros = false;
                }
                else {
                    //chunk[j] = arraz[j].substring(0, toTemp);
                    //chunk[j] = zeros.substring(0,-fromTemp)+chunk[j];

                    String tmp = arraz[j].substring(0, toTemp);
                    map.put(arraz[j], zeros.substring(0,-fromTemp)+tmp);

                    onlyZeros = Long.parseLong(tmp) == 0;
                }
            }

            if(onlyZeros)
                break;

            mergeSort(copyOfOrigin, chunk, 0, chunk.length-1);

            for(String a : copyOfOrigin)
                System.out.print(a + " ");

            System.out.println();
        }

    }

    private static void mergeSort(String[] origin, String[] chunk, int start, int end){
        if(start < end){

            int mid = (start + end) / 2;
            mergeSort(origin, chunk, start, mid);
            mergeSort(origin, chunk, mid+1, end);

            merge(origin, chunk, start, mid, end);
        }
    }

    private static void merge(String[] origin, String[] chunk, int start, int mid, int end){
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

            //long first = Long.parseLong(chunk[start]);
            //long second = Long.parseLong(chunk[mid+1]);
            long first = Long.parseLong(map.get(origin[start]));
            long second = Long.parseLong(map.get(origin[mid+1]));

            if(first > second) {
                temporary[i] = origin[mid+1] ;
                mid++;
            } else if(first == second){
                temporary[i++] = origin[start];
                temporary[i] = origin[mid+1];
                start++;
                mid++;
            } else {
                temporary[i] = origin[start];
                start++;
            }
        }

        int j=0;
        for(i = startCopy,  j = 0; i<= end; i++, j++){
            origin[i] = temporary[j];
        }
    }
}
