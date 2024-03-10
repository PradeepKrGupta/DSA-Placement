class Student{
    String name;
    int age, rollno;

    // Now creating the methods/Functions 
    public void printinfo(){
        System.out.println(this.name);
        System.out.println(this.age);
        System.out.println(this.rollno);
    }

    // creating the unparametrized constructor
    // Student(){
    //     System.out.println("Constructor called!");
    // }

    // creating the parametrized constructor where name, age and rollno have been passed
    Student(String name, int age, int rollno){
        this.name = name;
        this.age = age;
        this.rollno = rollno;
    }

    // Now creating the copy constructor
    Student(Student s2){
        this.name = s2.name;
        this.age = s2.age;
        this.rollno = s2.rollno;
    }

    // Here we have to create the default constructor  which will be called when no argument is provided while object creation
    Student(){
        
    }
}


public class ConstructorDet {

    public static void main(String args[]){
        // created object s1 and s2 and passing the info name, age and rollno to constructor so that it will be assign to object and then passes to method to get's print .
        // Student s1 = new Student("JayPrakash",24,567890);
        // Student s2 = new Student("Pradeep",22,21163);
        // s1.printinfo();
        // System.out.println();
        // s2.printinfo();


        // for copy constructor
        Student s1 = new Student();
        s1.name = "Hello";
        s1.age = 24;
        s1.rollno = 21163;
        Student s2 = new Student(s1);
        s2.printinfo();




    }
}
