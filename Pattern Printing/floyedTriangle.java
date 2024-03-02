import java.util.*;

public class floyedTriangle{
    public static void main(String[]args){
        int counter = 1;
        int n=5;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                System.out.print(counter);
                counter++;
            }
            System.out.println();
        }
    }
}


// output

/*
 
 */