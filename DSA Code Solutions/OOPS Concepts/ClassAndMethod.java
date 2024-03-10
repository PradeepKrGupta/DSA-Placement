import java.util.*;

class Student{
    String name;
    int age, rollno;

    // Now creating the methods/Functions 
    public void printinfo(){
        System.out.println(this.name);
        System.out.println(this.age);
        System.out.println(this.rollno);
    }
}
public class ClassAndMethod{
    public static void main(String args[]){
        // Now creating the objects of class and calling them
        Student s1 = new Student();
        Student s2 = new Student();
        s2.name = "JayPrakash";
        s1.name = "Pradeep";
        s1.age=24;
        s2.age = 22;
        s2.rollno = 567890;
        s1.rollno = 21163;

        s1.printinfo();
        System.out.println();
        s2.printinfo();
    }
}