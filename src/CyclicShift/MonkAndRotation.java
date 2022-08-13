package CyclicShift;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MonkAndRotation {
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input*/

        //BufferedReader
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //String name = br.readLine();                // Reading input from STDIN
        //System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\durov\\Downloads\\f9ee428ab15c11ea.txt.clean.txt"));
        // Write your code here
        int numOfCases = Integer.parseInt(br.readLine());

        int duration = 0;
        for(int test = numOfCases; test > 0; test--) {
            StringBuilder sb = new StringBuilder();

            String[] N_K = br.readLine().split(" ");
            String[] arr = br.readLine().split(" ");

            int K = Integer.parseInt(N_K[1]);

            int moves = K % arr.length;

            long start = System.currentTimeMillis();
            for(int i = arr.length-moves; i < arr.length; i++) {
                //System.out.print(arr[i] + " ");
                sb.append(arr[i]).append(" ");
            }

            for (int i =0; i < arr.length-moves; i++) {
                //System.out.print(arr[i] + " ");
                sb.append(arr[i]).append(" ");
            }
            duration += System.currentTimeMillis() - start;

            System.out.println(sb.toString());
            System.out.print("\n");
        }
        System.out.println("Running time: " + duration + " ms ");
    }
}
