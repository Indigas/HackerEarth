package Sorting;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MonkAndSortingAlgorithm {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());

        String[] arraz = Arrays.stream(br.readLine().split(" ")).toArray(String[]::new);
        String[] chunk = new String[length];
        String zeros = "00000";

        //first chunk
        for(int i = 1; ; i++){
            int from = 5*i;
            int to = 1+5*(i-1) - 1;

            for(int j = 0; j < length; j++){
                int fromTemp = arraz[j].length()-from;
                int toTemp = arraz[j].length()-to;

                if(toTemp<0){
                    chunk[j] = zeros;
                    continue;
                }

                if(fromTemp>-1)
                    chunk[j] = arraz[j].substring(fromTemp, toTemp);
                else {
                    chunk[j] = arraz[j].substring(0, toTemp);
                    chunk[j] = zeros.substring(0,-fromTemp)+chunk[j];

                }
            }
        }

    }
}
