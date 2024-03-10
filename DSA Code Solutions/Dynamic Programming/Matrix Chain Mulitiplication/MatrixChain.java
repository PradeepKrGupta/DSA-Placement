/*
Concept of matrix chain mulitplication
 Given : arr [] = {1, 2, 3, 4, 3}
 find minCost = ?
 ans = 30
 */

 import java.util.*;

//  ==================Using Recursion Method===================
// public class MatrixChain{
//     // defining the function
//     public static int mcm(int arr[], int i, int j){
//         // now getting the base case
//         if(i==j){
//             return 0;
//         }

//         // initializing the infinite value
//         int ans = Integer.MAX_VALUE;

//         for(int k=i;k<=j-1;k++){
//             int cost1 = mcm(arr, i, k);
//             int cost2 = mcm(arr, k+1, j);
//             int cost3 = arr[i-1]*arr[k]*arr[j];
//             int result = cost1+cost2+cost3;
//             ans = Math.min(ans,result);
//         }
//         return ans;
//     }

//     public static void main(String[] args){
//         int arr[] = {1, 2, 3, 4, 3};
//         int n = arr.length;
//         System.out.println(mcm(arr, 1, n-1));
//     }
// }



//  ==================Using DP Memoization Method===================
// public class MatrixChain{
//     // defining the function
//     public static int mcm(int arr[], int i, int j, int dp[][]){
//         // now getting the base case
//         if(i==j){
//             return 0;
//         }

//         if(dp[i][j]!=-1){
//             return dp[i][j];
//         }
//         // initializing the infinite value
//         int ans = Integer.MAX_VALUE;

//         for(int k=i;k<=j-1;k++){
//             int cost1 = mcm(arr, i, k,dp);
//             int cost2 = mcm(arr, k+1, j,dp);
//             int cost3 = arr[i-1]*arr[k]*arr[j];
//             int result = cost1+cost2+cost3;
//             ans = Math.min(ans,result);
//         }
//         return dp[i][j]=ans;
//     }

//     public static void main(String[] args){
//         int arr[] = {1, 2, 3, 4, 3};
//         int n = arr.length;
//         int dp[][] = new int[n][n];
//         for(int i=0;i<n;i++){
//             Arrays.fill(dp[i], -1);
//         }
        
//         System.out.println(mcm(arr, 1, n-1, dp));
//     }
// }



//  ==================Using DP Tabulation Method===================

public class MatrixChain{
    public static int Tabmcm(int arr[]){
        int n = arr.length;
        int dp[][] = new int[n][n];

        // initialization
        for(int i=0;i<n;i++){
            dp[i][i] = 0;
        }

        // bottom up
        for(int len=2;len<=n-1;len++){
            for(int i=1;i<=n-len;i++){
                int j = i+len-1; //col
                dp[i][j] = Integer.MAX_VALUE;
                for(int k=i;k<=j-1;k++){
                    int cost1 = dp[i][k];
                    int cost2 = dp[k+1][j];
                    int cost3 = arr[i-1]*arr[k]*arr[j];
                    dp[i][j] = Math.min(dp[i][j], cost1+cost2+cost3);
                }
            }
        }

        // for printing the table
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return  dp[1][n-1];

    }

    public static void main(String[] args){
        int arr[] = {1, 2, 3, 4, 3};
        System.out.println(Tabmcm(arr));
        
    }
}