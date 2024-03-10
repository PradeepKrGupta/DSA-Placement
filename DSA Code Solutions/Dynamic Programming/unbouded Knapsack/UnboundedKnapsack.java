/*
 val[] = {15, 14, 10, 45, 30}
 wt[] = {2, 5, 1, 3, 4}
 W (total allowed weight)= 7
 */

import java.util.*;

public class UnboundedKnapsack{
    public static void printDP(int dp[][]){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static int unbound(int val[], int wt[], int W){
        int n = val.length;
        int[][] dp = new int[n+1][W+1];

        for(int i=0;i<n+1;i++){
            dp[i][0] = 0;
        }
        for(int j=0;j<W+1;j++){
            dp[0][j] = 0;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<W+1;j++){
                if(wt[i-1]<=j){
                    // for include
                    dp[i][j] = Math.max(val[i-1]+dp[i][j-wt[i-1]], dp[i-1][j]);
                }
                else{
                    // for exclude
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        printDP(dp);
        return dp[n][W];
    }
    public static void main(String[]args){
        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};
        int W = 7;

        System.out.println("Max Profit: "+unbound(val, wt, W));
    }
}


/*
Output: 
0 0 0 0 0 0 0 0         
0 0 15 15 30 30 45 45   
0 0 15 15 30 30 45 45   
0 10 20 30 40 50 60 70  
0 10 20 45 55 65 90 100 
0 10 20 45 55 65 90 100 

Max Profit: 100 

*/