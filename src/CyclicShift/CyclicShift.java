package CyclicShift;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class CyclicShift {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCases; i++) {
            String[] N_K = br.readLine().split(" ");
            int N = Integer.parseInt(N_K[0]);
            long K = Long.parseLong(N_K[1]);

            char[] binaryNumber = br.readLine().toCharArray();

            BigInteger B = new BigInteger("0", 2);
            long total = 0;
            int count = 0;
            int start = 0;
            int end = 0;

            char[] temp = new char[binaryNumber.length];
            String binaryString = String.valueOf(binaryNumber);
            String doubleString = binaryString + binaryString;

            int foundString = 0;
            B = new BigInteger(binaryString, 2);
            String[] arr = doubleString.split("0+");
            int maxNumOfOnes = 0;
            String ones = "1";
            for (String a : arr) {
                int tmp = a.length();
                if (maxNumOfOnes < tmp) {
                    maxNumOfOnes = tmp;
                    ones = a;
                }
            }

            while (true) {
                foundString = doubleString.indexOf("0" + ones, foundString);
                if (foundString == -1) {
                    foundString = 0;
                    break;
                }

                foundString++;
                int endStr = foundString + N;
                if (endStr > (N * 2 - 1))
                    break;

                BigInteger bb = new BigInteger(doubleString.substring(foundString, endStr), 2);
                if (B.compareTo(bb) < 0) {
                    B = bb;
                    total = foundString;
                }
                foundString++;
            }

            String bigInteger = doubleString.substring((int) total, (int) total + N);

            long lastCount = -1;

            String maxi = bigInteger;
            String full = maxi + maxi;
            int found = 0;

            while (true) {
                found = full.indexOf("01", found);
                if (found == -1) {
                    lastCount = 1;
                    break;
                }

                found++;
                int endStr = found + bigInteger.length();

                if (full.substring(found, endStr).contains(maxi)) {
                    lastCount = found;
                    break;
                }
            }

            lastCount = lastCount * (K - 1);
            total += lastCount;

            System.out.println(total);
        }
    }
}
