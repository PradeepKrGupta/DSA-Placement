/*
 We are given an infinite supply of denomination [1,2,5,10,20,50,100,500,2000]. find min no of coins/notes to make change for a V.
 V = 121
 ans = 3 (100+20+1); 
 */

import java.util.*;
public class IndianCoin {
    public static void main(String[] args){
        Integer arr[] = {1,2,5,10,20,50,100,500,2000};
        // for reversing the array in java
        Arrays.sort(arr, Comparator.reverseOrder());
        int V = 121;
        int count =0;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=V){
                while(arr[i]<=V){
                    count++;
                    ans.add(arr[i]);
                    V -= arr[i];
                }
            }
        }
        for(int i=0;i<ans.size();i++){
            System.out.println("Coins used in :"+ans.get(i));
        }
        System.out.println("The number of coints used is :"+count);
    }
}
