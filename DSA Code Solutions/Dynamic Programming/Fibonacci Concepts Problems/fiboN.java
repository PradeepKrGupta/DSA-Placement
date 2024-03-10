import java.util.*;

// Recursive Method : (Time complexity : O(2^n))
// public class fiboN{
//     public int fibo(int n){
//         if(n==0 || n==1){
//             return n;
//         }
//         return fibo(n-1)+fibo(n-2);
//     }
//     public static void main(String[]args){
//         int n=6;
//         fiboN f = new fiboN();
//         System.out.println(f.fibo(n));
//     }
// }



// Dynamic Method using Memoization: (Time complexity : O(n))


// public class fiboN{
//     public int fibo(int n, int f[]){
//         if(n==0 || n==1){
//             return n;
//         }
//         if(f[n]!=0){
//             return f[n];
//         }
//         f[n] = fibo(n-1, f)+fibo(n-2, f);
//         return f[n];
//     }
//     public static void main(String[]args){
//         fiboN c = new fiboN();
//         int n=6;
//         int[] f = new int[n+1];
//         System.out.println(c.fibo(n,f));
//     }
// }


// Dynamic Method using Tabulation: (Time complexity : O(n))


public class fiboN{
    public int fibo(int n){
        int [] dp = new int[n+1];
        dp[0]= 0;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    public static void main(String[]args){
        fiboN c = new fiboN();
        int n=6;
        System.out.println(c.fibo(n));
    }
}