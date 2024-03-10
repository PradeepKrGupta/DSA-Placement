/*
 Given A:[4,1,8,7], B:[2,3,6,5]
 write a program to find the minimum abosulte difference between the pairs of the given arrays.
 example case1: |4-2|+|1-3|+|8-6|+|7-5|=9
         case2: |1-2|+|4-3|+|7-5|+|8-6|=6 (which is minimum so, it's a correct answer because for this other case will give equal or more then 6)
 */

import java.util.*;
public class MinAbsoluteDiff {
    public static void main(String args[]){

        int[] A ={4,1,8,7}; 
        int[] B ={2,3,6,5};
        
        // Sorting it, so that minimum will be subtracted from minimum.
        Arrays.sort(A);
        Arrays.sort(B);

        int sum = 0;
        for(int i=0;i<A.length;i++){
            sum += Math.abs(A[i]-B[i]);

        }
        System.out.println("Minimum absolute diff is :"+sum);


    }

}
