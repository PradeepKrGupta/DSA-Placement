/*
 MaxLengthChain we need to find out where given pairs here b<c
 (5,24), (39, 60), (5, 28), (27, 40), (50, 90)
 ans = 3 (longest chain)
 */

import java.util.*;
public class  MaxLengthChain {
    public static void main(String args[]){
        int[][] arr = {{5,24}, {39, 60}, {5, 28}, {27, 40}, {50, 90}};
        Arrays.sort(arr, Comparator.comparing(o->o[1]));

        int ans = 1;
        int lastend = arr[0][1];

        for(int i=1;i<arr.length;i++){
            if(arr[i][0]>lastend){
                ans++;
                lastend = arr[i][1];
            }

        }
        System.out.println(ans);
    }

}