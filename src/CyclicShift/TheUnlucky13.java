package CyclicShift;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;

public class TheUnlucky13 {
    private static HashMap<Long, BigInteger> cache = new HashMap<>();
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());


        cache.put(0L,BigInteger.valueOf(1L));
        cache.put(1L,BigInteger.valueOf(10L));
        cache.put(2L,BigInteger.valueOf(99L));
        cache.put(3L,BigInteger.valueOf(980L));
        cache.put(4L,BigInteger.valueOf(9701L));
        cache.put(5L,BigInteger.valueOf(96030L));
        cache.put(6L,BigInteger.valueOf(950599L));

        for( ; testCases>0;testCases--){
            long stringLength = Long.parseLong(br.readLine());

            System.out.println(get(stringLength));

        }
    }

    private static BigInteger get(long stringLength){
        if(cache.containsKey(stringLength))
            return cache.get(stringLength);

        long mod = 1000000009L;
        BigInteger x = get(stringLength/2);
        BigInteger y = get(stringLength/2-1);


        if((stringLength % 2) == 0) {
            cache.put(stringLength, (x.multiply(x).subtract(y.multiply(y))).mod(BigInteger.valueOf(mod)));
        }
        else {
            BigInteger z = get(stringLength / 2 +1);
            cache.put(stringLength, (x.multiply(z.subtract(y))).mod(BigInteger.valueOf(mod)));
        }

        return cache.get(stringLength);
    }
}
