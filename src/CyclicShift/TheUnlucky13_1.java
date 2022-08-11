package CyclicShift;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TheUnlucky13_1 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        long modulo = 1000000009L;

        long start=0L;
        for( ; testCases>0;testCases--) {
            long stringLength = Long.parseLong(br.readLine());

            long[][] arr = {{10,-1}, {1,0}};

            if(start==0L)
                start = System.currentTimeMillis();

            System.out.println(exp(arr, stringLength));
        }

        System.out.println("Running time: "+(System.currentTimeMillis()-start) + " ms");
    }


    private static long exp(long[][] arr, long n){
        long[][] res = {{1,0},{0,1}};
        while(n!=0){
            if(n%2 != 0)
                res=mul(res, arr);

            n/=2;
            arr = mul(arr, arr);
        }
        return res[0][0];
    }

    private static long[][] mul(long[][] a, long[][] b){
        int mod = 1000000009;
        long[][] prod = new long[2][2];
        for(int i = 0; i < 2; i++)
            for(int j = 0; j < 2; j++)
                for(int k = 0; k < 2; k++)
                    prod[i][j] = Math.floorMod(
                            prod[i][j] + a[i][k] * b[k][j], mod
                    );

        return prod;
    }
}
