/*
Problem: to find the max profit
val[] = 15, 14, 10, 45, 30
wt[] = 2, 5 , 1, 3, 4
W(total weight allowed) = 7
ans = max profit

 */


//  Using Recursion Approact to solve this problem
// Time complexity : 0(2^n)

// import java.util.*;

// public class ZeroOneKnapsack{
//     public static int knapsack(int val[], int wt[], int W, int n){
//         if(W==0 || n==0){
//             return 0;
//         }
//         if(wt[n-1]<=W){
//             // including
//             int ans1 = val[n-1]+knapsack(val, wt, W-wt[n-1], n-1);
//             // excluding
//             int ans2 = knapsack(val, wt, W, n-1);
//             return Math.max(ans1, ans2);
//         }
//         else{
//             return knapsack(val, wt, W, n-1);
//         }
//     }
//     public static void main(String[]args){
//         int val[] = {15, 14, 10, 45, 30};
//         int wt[] = {2, 5 , 1, 3, 4};
//         int W = 7;
//         int n = val.length;
//         System.out.println("Max profit : "+knapsack(val, wt, W, n));
//     }
// }





//  Using Dynamic Programming approach using Memoization to solve this problem
// Time complexity : 0(n*W)

// import java.util.*;

// public class ZeroOneKnapsack{
//     public static int knapsack(int val[], int wt[], int W, int n, int dp[][]){
//         if(W==0 || n==0){
//             return 0;
//         }
//         if(dp[n][W]!=-1){
//             return dp[n][W];
//         }
//         if(wt[n-1]<=W){ //valid
//             // Including
//             int ans1 = val[n-1]+knapsack(val, wt, W-wt[n-1], n-1, dp);

//             // Excluding
//             int ans2 = knapsack(val, wt, W, n-1, dp);
//             dp[n][W] = Math.max(ans1, ans2);
//             return dp[n][W];
//         }
//         else{ //Invalid
//             dp[n][W] = knapsack(val, wt, W, n-1, dp);
//             return dp[n][W];
//         }

//     }
//     public static void main(String[]args){
//         int val[] = {15, 14, 10, 45, 30};
//         int wt[] = {2, 5 , 1, 3, 4};
//         int W = 7;
//         int n = val.length;
//         // creating the 2D array to store the calculated profit
//         int[][] dp = new int[n+1][W+1];
//         for(int i=0;i<dp.length;i++){
//             for(int j=0;j<dp[0].length;j++){
//                 dp[i][j]=-1;
//             }
//         }

//         System.out.println("Max profit using Memoization : "+knapsack(val, wt, W, n, dp));

//     }
// }




//  Using Dynamic Programming approach using Tabulation to solve this problem
// Time complexity : 0(n*W)

import java.util.*;

public class ZeroOneKnapsack{
    public static void printDP(int dp[][]){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int knapsack(int val[], int wt[], int W){
        int n = val.length;
        int[][] dp = new int[n+1][W+1];

        for(int i=0;i<dp.length;i++){  //0th column
            dp[i][0] = 0;
        }

        for(int j=0;j<dp[0].length;j++){  //0th row
            dp[0][j] = 0;
        }

        // Now adding the values in the table
        for(int i=1;i<n+1;i++){
            for(int j=1;j<W+1;j++){
                int v = val[i-1]; //ith item val
                int w = wt[i-1];  //ith item weight
 
                if(w<=j){
                    int incProfit = v+dp[i-1][j-w];
                    int excProfit = dp[i-1][j];
                    dp[i][j] = Math.max(incProfit, excProfit);
                }
                else{
                    int excProfit = dp[i-1][j];
                    dp[i][j] = excProfit;

                }
            }
        }
        printDP(dp);
        return dp[n][W];

    }
    public static void main(String[]args){
        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5 , 1, 3, 4};
        int W = 7;
        System.out.println("Max profit using Memoization : "+knapsack(val, wt, W));

    }
}



/*
 Output:

0 0 0  0  0  0  0  0        
0 0 15 15 15 15 15 15  
0 0 15 15 15 15 15 29  
0 10 15 25 25 25 25 29 
0 10 15 45 55 60 70 70 
0 10 15 45 55 60 70 75 

Max profit using Memoization : 75

 */