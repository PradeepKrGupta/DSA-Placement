import java.util.*;
public class HollowRect {
    public static void main(String[]args){
        int toRows=4;
        int toCols=4;
        for(int i=1;i<=toRows;i++){
            for(int j=1;j<=toCols;j++){
                if(i==1 || i==toRows || j==1 || j==toCols){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}



// output
/*

****
*  *
*  *
****

 */