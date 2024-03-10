// Numbers [] = {4,2,7, 1,3}
// Target sum = 10
// Here we need to find the Among these values if any subset exists. that is equal to target then return True else return false

import java.util.*;
public class TargetSumSubset {
    public static void printDP(boolean dp[][]){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static boolean TargetSum(int num[], int sum ){
        int n = num.length;
        boolean[][] dp = new boolean[n+1][sum+1];

        for(int i=0;i<n+1;i++){
            dp[i][0]=true;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                int v = num[i-1];

                // include
                if(v<=j && dp[i-1][j-v]==true){
                    dp[i][j]=true;
                }
                // exclude
                else if(dp[i-1][j]==true){
                    dp[i][j]=true;
                }
            }
        }
        printDP(dp);
        return dp[n][sum];
    }

    public static void main(String[]args){
        int num[] = {4,2,7, 1,3};
        int  target_sum = 10;
        System.out.println(TargetSum(num, target_sum));
    }
}
