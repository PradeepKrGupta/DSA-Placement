/*
 Given : arr[] = {50, 3, 10, 7, 40, 80}
 length of Longest Common Subsequence = 4
 */
import java.util.*;
public class LongestCommonIncreasingSubsequence {
    public static int lcsOfTwoArrays(int arr1[]){
        int n = arr1.length;

        // creating the Hashset and storing the arr1 value into it.
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(arr1[i]);
        }
        // converting the Hashset into arr2.
        int m = set.size();
        int arr2[] = new int[m];

        int i=0;
        for(int num : set){
            arr2[i] = num;
            i++;
        }
        // sorting it.
        Arrays.sort(arr2);

        // creating dp array of n+1 * m+1 dimension;
        int[][] dp = new int[n+1][m+1];

        for(i=0;i<n+1;i++){
            dp[i][0] = 0;
        }

        for(int j=0;j<m+1;j++){
            dp[0][j] = 0;
        }

        for(i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(arr1[i-1]==arr2[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else{
                    int ans1 = dp[i-1][j];
                    int ans2 = dp[i][j-1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }
        
        return dp[n][m];
    }
    public static void main(String[]args){
        int arr1[] = {50, 3, 10, 7, 40, 80};
        System.out.println("Length of LCS is " + lcsOfTwoArrays(arr1));
    }
}
