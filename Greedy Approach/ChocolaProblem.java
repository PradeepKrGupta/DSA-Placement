/*
 Hard Level Question
 1.ChocolaProblem (Platform available called SPOJ)
 2.Min cost to cut board into square (other name)

 We are given a bar of chocolate composed of m*n square pieces. One should break the chocolate into singele squares. Each break of a part of the chocolate is changed a cost expressed by a positive integer. This cost doesnot depend on the  size of the part that is being broked but only depends on the line the break goes along. Let us dentote the cost of breaking along consecutive vertical line with x1, x2, ... xm-1 and along horizontal lines. with y1, y2, .. yn-1

 compute the minimal cost of breaking the whole chocolate into single squres
   
 */

import java.util.*;

public class ChocolaProblem {
    public static void main(String[] args) {
        // int n = 4, m = 6;
        Integer costVer[] = { 2, 1, 3, 1, 4 }; // m-1
        Integer costHor[] = { 4, 1, 2 }; // n-1

        // Sorting it in descending order to get the max price of cost first
        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());


        // Now intitializing the pointers and the pieces
        int h=0,v=0;
        int hp=1,vp=1;
        int cost = 0;

        while(v<costVer.length && h<costHor.length){
            if(costVer[v]<=costHor[h]){ //Horizontal cut then
                cost += (costHor[h]*vp);
                hp++;
                h++;
            }
            else{
                cost += (costVer[v]*hp);
                vp++;
                v++;
            }
        }

        // if any remaining  piece is there add them to the total cost through pieces
        while(v<costVer.length){
            cost += (costVer[v]*hp);
            vp++;
            v++;
        }
        while(h<costHor.length){
            cost += (costHor[h]*vp);
            hp++;
            h++;
        }

        System.out.println("Minimum cost of it is : " + cost);
    }

}
