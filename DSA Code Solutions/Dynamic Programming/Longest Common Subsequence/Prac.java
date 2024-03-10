import java.util.*;
public class Prac {
    public static void pal(String s){
        int n = s.length();
        StringBuilder st = new StringBuilder();
        for(int i=n;i>0;i--){
            st.append(s.charAt(i-1));
        }
        String str = st.toString();
        System.out.println(str);
    }
    public static void main(String[]args){
        String s = "bbbab";
        pal(s);
        // System.out.println("Original string is : "+pal(s));
    }
}
