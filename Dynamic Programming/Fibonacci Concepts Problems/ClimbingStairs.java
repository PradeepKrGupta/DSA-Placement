// Problem (Climbing Stairs) 
// Explaination: find the number of ways to to reach to the top of stairs, where 1 and 2 jumps are allowed....

import java.util.*;

// Here we use memoization for this..............
public class ClimbingStairs{
    public int climbStairs(int n, int f[]){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        if(f[n]!=0){
            return f[n];
        }
        f[n] = climbStairs(n-1, f)+climbStairs(n-2, f);
        return f[n];

    }
    public static void main(String[]args){
        ClimbingStairs c = new ClimbingStairs();
        Scanner read = new Scanner(System.in);
        System.err.println("Enter the number of stairs");
        int n = read.nextInt();
        int[] f = new int[n+1];
        System.out.println("The number of ways to climb " +n+ "stairs is "+c.climbStairs(n, f));


    }
}


// suppose it ask to allowed to jump 1, 2 and 3 stairs then we simply have to change only 

//====== f[n] = climbStairs(n-1, f)+climbStairs(n-2, f)+climbStairs(n-3, f);==========