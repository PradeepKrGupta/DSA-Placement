import java.util.*;

public class StackCustom {
    int top;
    int size;
    int[] arr;

    StackCustom(int size){
        this.top=-1;
        this.size=size;
        arr = new int[size];
    }

    // creating the isempty  and isfull function
    public boolean isempty(){
        return top<0;
    }

    public boolean isfull(){
        return top==size-1;
    }

    // creating push and pop function;
    public void push(int data){
        if(isfull()){
            return;
        }
        arr[++top] =data;
        System.out.println(data+" :is pushed");
    }

    public int pop(){
        if(isempty()){
            System.out.println("Stack underflow");
        }
        int x = arr[top--];
        return x;
    }

    // creating the peak function
    public int peek(){
        if(isempty()){
            System.out.println("Stack underflow");
        }
        return arr[top];
    }

    public void printStack(){
        if(isempty()){
            System.out.println("Stack is empty");
        }
        for(int i=top;i>0;i--){
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args){
        StackCustom s = new StackCustom(5);
        s.push(43);
        s.push(24);
        s.push(54);
        s.push(56);
        s.push(7);
        System.out.println(s.pop()+" is poped");
        System.out.println(s.pop()+" is poped");
        System.out.println(s.peek()+" is on the peek");
        s.printStack();
    }



}