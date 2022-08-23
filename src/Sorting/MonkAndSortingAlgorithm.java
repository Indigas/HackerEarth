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
    private static boolean onlyZeros = true;
    private static int power;
    public static void main(String[] args) throws Exception {
        String file = "C:\\Users\\durov\\Downloads\\110bae8ab15d11ea.txt.clean.txt";

        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = Files.newBufferedReader(Paths.get(file));
        FastReader.Reader br = new FastReader.Reader(file);
        int length = Integer.parseInt(br.readLine());

        long startProgram = System.currentTimeMillis();
        /*from = 5*1;
        to = 1+5*(1-1) - 1;

        String[] arraz = Arrays.stream(br.readLine().split(" ")).sorted((s, s1) -> {
            long a = calc(s);
            long b = calc(s1);

            return Long.compare(a,b);
        }).toArray(String[]::new);*/

        long[] arraz = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        br.close();

        // chunk
        for(int i = 1; ; i++){
            map.clear();
            onlyZeros = true;
            from = 5*i;
            to = 1+5*(i-1) - 1;

            int pow = (from-to)*i;
            power = i;


            /*for(int j = length; j < length; j++){
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

            }*/

            mergeSort(arraz, 0, arraz.length-1);
            //Arrays.sort(arraz, Comparator.comparing(t -> calc(t)));


            if(onlyZeros)
                break;

            StringBuilder sb = new StringBuilder();
            for(long a : arraz)
                sb.append(a).append(" ");

            System.out.println(sb.toString());

        }
        long endProgram = System.currentTimeMillis();

        System.out.printf("Program runs %d ms\n", endProgram - startProgram);


    }

    private static void mergeSort(long[] origin, int start, int end){
        if(start < end){

            int mid = (start + end) / 2;
            mergeSort(origin, start, mid);
            mergeSort(origin, mid+1, end);

            merge(origin, start, mid, end);
        }
    }

    private static void merge(long[] origin, int start, int mid, int end){
        long[] temporary = new long[end-start+1];

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

            //long first = map.get(origin[start]);
            //long second = map.get(origin[mid+1]);
            //long first = calc(origin[start]);
            //long second = calc(origin[mid+1]);
            double st = origin[start];
            double md = origin[mid+1];
                for (int a = 1; a <= power; a++)
                    st = st / 100000;

                for (int a = 1; a <= power; a++)
                    md = md / 100000;

            long first = Math.round((st - ((long)st))*100000);
            long second = Math.round((md - ((long)md))*100000);

            if(first != 0 || second != 0)
                onlyZeros = false;

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

    private static long calc(String s){
        int fromTemp = s.length()-from;
        int toTemp = s.length()-to;

        if(toTemp<=0){
            return 0;
        }


        if(fromTemp<0) {
            fromTemp=0;
        }

        onlyZeros=false;
        return Long.parseLong(s.substring(fromTemp, toTemp));
    }

}
