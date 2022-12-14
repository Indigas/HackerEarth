package Searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class MonkAndSearch {
    public static void main(String[] args) throws IOException {

        String file = "C:\\Users\\durov\\Downloads\\256220eeb15d11ea.txt.clean.txt";
        BufferedReader br = Files.newBufferedReader(Paths.get(file));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MonkAndSearch mAs = new MonkAndSearch();

        long start = System.currentTimeMillis();
        int N = Integer.parseInt(br.readLine());
        int[] arrayOfN = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

        int Q = Integer.parseInt(br.readLine());
        int[][] queries = new int[Q][2];


        for(int i = 0; i < Q; i++){
            String[] inputQuery = br.readLine().split(" ");
            queries[i][0] = Integer.parseInt(inputQuery[0]);
            queries[i][1] = Integer.parseInt(inputQuery[1]);
        }

        StringBuilder sb = new StringBuilder();
        for(int[] a : queries){
            //System.out.println(mAs.findDifference(arrayOfN, a[0], a[1]));
            sb.append(mAs.findDifference(arrayOfN, a[0], a[1])).append("\n");
        }

        System.out.println(sb.toString());
        System.out.println("Calculation runs in ms: " + (System.currentTimeMillis() - start));

    }

    private int findDifference(int[] array, int less, int x){
        int[] match = binarySearch(array, x);

        if(less == 0)
            return findNotLessThanX(array.length, findLeftMost(array, x, match[0]));

        return findMoreThanX(array.length, findRightMost(array, x, match[1]));
    }

    private int findNotLessThanX(int sizeOfArray, int index){
        return sizeOfArray - index;
    }

    private int findMoreThanX(int sizeOfArray, int index){
        return sizeOfArray - index;
    }

    private int findLeftMost(int[] array, int x, int index){
        int leftMost = index;

        if(leftMost == 0)
            return index;

        int found = leftMost;
        while(found > -1) {
            if(leftMost > found) {
                leftMost = found;
            }

            found = Arrays.binarySearch(array, 0, leftMost, x);
        }

        return leftMost;
    }

    private int findRightMost(int[] array, int x, int index){
        int rightMost = index;

        if(rightMost == array.length )
            return index;

        int found = rightMost;
        while(found > -1){
            if(rightMost < found){
                rightMost = found;
            }

            found = Arrays.binarySearch(array, rightMost+1, array.length, x);
        }

        if(array[rightMost]==x)
            rightMost += 1;

        return rightMost;
    }
    private int[] binarySearch(int[] array, int x){

        if(array[array.length-1] < x)
            return new int[]{array.length,array.length};
        else if (array[0] > x)
            return new int[]{0, 0};
        else if(array[array.length-1] == x)
            return new int[]{array.length, array.length};

        int lower = -1;
        int higher = -1;

        int mid = 0;
        int rest = 0;
        int top = array.length;

        while(true){
            mid = (rest + top - 1) / 2 ;

            if(array[mid] == x ){
                return new int[]{mid,mid};
            } else {
                if( array[mid] > x ){
                    if(array[mid-1] < x )
                        return new int[]{mid, mid};
                    else if(array[mid-1]==x)
                        return new int[]{mid-1, mid-1};
                    else
                        top = mid;
                } else {
                    if(array[mid+1] > x)
                        return new int[]{mid+1, mid+1};
                    else if(array[mid+1]==x)
                        return new int[]{mid+1, mid+1};
                    else
                        rest = mid+1;
                }
            }


        }
    }
}
