/*
 Print the n catalana number
 C0 = 1
 C1 = 1
 C2 = C0.C1 + C1.C0 = 2
 C3 = C0.C2 + C1.C1 + C2.C0 = 5
 C4 = C0 C3+C2 C2 + C3 C1 + C3 C0 = 14

 */

//  ===============Using recursion method=============
import java.util.*;

// public class Catlana{
//     public static int catalana(int n){
//         // Base case 
//         if(n==0 || n==1){
//             return 1;
//         }
//         int ans = 0;
//         for(int i=0;i<=n-1;i++){
//             ans+= catalana(i)*catalana(n-i-1);
//         }
//         return ans;
//     }
//     public static void main(String []args){
//         int n = 4;
//         System.out.println(catalana(n));
//     }
// }


//  ===============Using DP memoization method=============

// public class Catlana{
//     public static int catalana(int n, int dp[]){
//         // Base case 
//         if(n==0 || n==1){
//             return 1;
//         }
        
//         if(dp[n]!=-1){
//             return dp[n];
//         }
//         for(int i=0;i<=n-1;i++){
//             dp[n] +=catalana(i,dp)*catalana(n-i-1,dp);
//         }
//         return dp[n];
//     }
//     public static void main(String []args){
//         int n = 3;
//         int dp[] = new int[n+1];
//         Arrays.fill(dp,-1);
//         System.out.println(catalana(n, dp));
//     }
// }




//  ===============Using DP Tabulation method=============

public class Catlana{
    public static int catalana(int n){
        // Base case
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++){
                dp[i] += dp[j]*dp[i-j-1];
            }
        }
        return dp[n];
    }
    public static void main(String []args){
        int n = 10;

        System.out.println(catalana(n));
    }
}
