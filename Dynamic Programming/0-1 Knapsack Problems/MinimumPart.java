/*
 Given numbers[] = {1, 6, 11, 5}
 min diff = 1

 This problem related to 0-1 knapsack
 */

import java.util.*;
public class MinimumPart {
    public static int minPart(int nums[]){
        int n = nums.length;
        int TotalSum = 0;
        for(int i=0;i<n;i++){
            TotalSum += nums[i];
        }
        int W = TotalSum/2;

        int dp[][] = new int[n+1][W+1];

        for(int i=0;i<n+1;i++){
            dp[i][0] = 0;
        }

        for(int j=0;j<W+1;j++){
            dp[0][j] = 0;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<W+1;j++){
                if(nums[i-1]<=j){
                    int incProf = nums[i-1]+dp[i-1][j-nums[i-1]];
                    int excProf = dp[i-1][j];
                    dp[i][j] = Math.max(incProf, excProf);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        int sum1 = dp[n][W];
        int sum2 = TotalSum-sum1;
        return Math.abs(sum1-sum2);

    }
    public static void main(String[] args){
        int nums[] = {3,9,7,3};
        System.out.println(minPart(nums));
    }
}
