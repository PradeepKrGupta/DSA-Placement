/*
 value = [60, 100, 120]
 weight = [10, 20, 30]
 W = 50, ans = 240
 */

import java.util.*;

public class FractionalKnapsack{
    public static void main(String args[]){
        int []value = {60, 100, 120};
        int []weight = {10, 20, 30};
        int W = 50;

        double[][] ratio = new double[value.length][2];
        for(int i=0;i<value.length;i++){
            ratio[i][0] = i;
            ratio[i][1]= value[i]/(double)weight[i];
        }

        // Now sorting as for the ratio
        Arrays.sort(ratio, Comparator.comparing(o->o[1]));

        // Now reversing the loop and start comparing
        int capacity = W;
        int finalval = 0;
        for(int i=value.length-1;i>=0;i--){
            int idx = (int)ratio[i][0];
            if(capacity>=weight[idx]){
                finalval += value[idx];
                capacity -= weight[idx];
            }else{
                finalval += (ratio[i][1]*capacity);
                capacity =0;
                break;
            }
        }

        System.out.println("Final Value : "+finalval);

        
    }
}