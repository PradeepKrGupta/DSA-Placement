/*
 Given : int arr[] = {2, 3, 1, 1, 4}
 min jumps = 2
 */
import java.util.*;
public class MinJump {
    public static int mj(int arr[]){
        int n = arr.length;
        int dp[] = new int[n];
        // filling the dp array with -1 bydefault it was 0.
        Arrays.fill(dp, -1);
        dp[n-1] = 0;

        

        // creating the loops for the minjumps
        for(int i=n-2;i>=0;i--){
            int steps = arr[i];
            int ans = Integer.MAX_VALUE;
            for(int j=i+1;j<=i+steps && j<n; j++){
                if(dp[j]!=-1){
                    ans = Math.min(ans, dp[j]+1);
                }
            }
            if(ans!=Integer.MAX_VALUE){
                dp[i] = ans;
            }
        }
        // Because the dp[0] is the first index from where we find out the next how many steps we can jumps
        return dp[0];
        
    }
    public static void main(String args[]){
        int arr[] = {2, 3, 1, 1, 4};
        System.out.println(mj(arr));
    }
}
