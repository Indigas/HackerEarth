/* IMPORTANT: Multiple classes and nested static classes are supported */
package CyclicShift;
/*
 * uncomment this if you want to read input.*/
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass {
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input*/

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Write your code here

        //String inputBinary = br.readLine();
        //System.out.println(Integer.parseInt(inputBinary, 2));

        int testCases = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCases; i++){
            String[] N_K = br.readLine().split(" ");
            int N = Integer.parseInt(N_K[0]);
            long K = Long.parseLong(N_K[1]);

            char[] binaryNumber = br.readLine().toCharArray();

            BigInteger B = new BigInteger("0", 2);
            long total=0;
            int count=0;
            int start = 0;
            int end = 0;

            char[] temp = new char[binaryNumber.length];
            String binaryString = String.valueOf(binaryNumber);
            String doubleString = binaryString + binaryString;

            int foundString=0;
            //first string biggest
            B = new BigInteger(binaryString,2);
            String[] arr = doubleString.split("0+");
            int maxNumOfOnes = 0;
            String ones="1";
            for(String a : arr){
                int tmp = a.length();
                if (maxNumOfOnes < tmp) {
                    maxNumOfOnes = tmp;
                    ones = a;
                }
            }

            while(true) {
                foundString = doubleString.indexOf("0"+ones, foundString);
                if(foundString==-1) {
                    foundString=0;
                    break;
                }

                foundString++;
                int endStr = foundString + N;
                if(endStr>(N*2-1))
                    break;

                BigInteger bb = new BigInteger(doubleString.substring(foundString, endStr),2);
                if (B.compareTo(bb) < 0){
                    B = bb;
                    total = foundString;
                }
                foundString++;
            }

            String bigInteger = doubleString.substring((int)total, (int)total+N);
            //B = new BigInteger(String.valueOf(bigInteger),2);
            //total = foundString;

          /*  for(int j = 0, k = 0, cyclus = 0; cyclus < binaryNumber.length; j++, k++){

                if(k < binaryNumber.length)
                    temp[j]=binaryNumber[k];
                else
                    temp[j] = binaryNumber[k - binaryNumber.length];

                if(j == (binaryNumber.length-1)){
                    j=-1;
                    k = cyclus;

                    BigInteger mx = new BigInteger(String.valueOf(temp),2);
                    if(B.compareTo(mx) < 0) {
                        B = mx;
                        total = cyclus;
                    }
                    cyclus++;

                }
            }*/

            start = (int)total;

            /*char[] max = new char[N];
            for (int j = 0; j < N; j++){
                int tempa = start+j;

                if(tempa<N)
                    max[j]=binaryNumber[tempa];
                else
                    max[j]=binaryNumber[tempa-N];
            }*/

            BigInteger biggest = new BigInteger(String.valueOf(bigInteger), 2);

            long lastCount = -1;

            /*for(int j = 0; ; j++){
                char[] last = new char[max.length];
                for (int s = 0; s < last.length; s++){
                    int tmp = s+j;

                    if(tmp < max.length)
                        last[s] = max[tmp];
                    else
                        last[s] = max[tmp%max.length];
                }
                lastCount++;
                BigInteger tempa = new BigInteger(String.valueOf(last),2);

                if(tempa.compareTo(biggest)==0 && lastCount>0) {
                        lastCount = lastCount*(K-1);
                        total+=lastCount;
                        break;

                }
            }*/

            String maxi = String.valueOf(bigInteger);
            String full = maxi+maxi;
            lastCount++;
            int found = 0;

            while(true) {
                found = full.indexOf("01", found);
                if(found==-1) {
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

            lastCount = lastCount*(K-1);
            total+=lastCount;

            System.out.println(total);

        }
    }
}
