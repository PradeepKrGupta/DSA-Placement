import java.util.*;

class Shape{
    public void area(){
        System.out.println("The area is");
    }
}
// Now trying the single level inheritance
class Triangle extends Shape{
    public void area(int l, int b){
        System.out.println("The area is"+0.5*l*b);
    }
}
// Now trying the multilevel inheritance
class Equilateral extends Triangle{
    public void area(int l){
        System.out.println("The area is"+l*l*l);
    }
}

// Now trying the heiarhical inheritance
class Rectangle extends Triangle{
    
}

public class Inheritance {
   public static void main(String args[]){
    // Creating objects of different classes
    Rectangle s1 = new Rectangle();
    s1.area(5, 6);
   } 
}
