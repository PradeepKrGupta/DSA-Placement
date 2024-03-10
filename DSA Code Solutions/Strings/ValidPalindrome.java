
// mycode==========unoptimized=====Time:151ms=================================
class Solution {
    public boolean isPalindrome(String s) {
        String res = s.replaceAll("[^0-9a-zA-Z]","");
        String newRes = res.toLowerCase();
        String reverseStr = "";
        for(int i=0;i<newRes.length();i++){
            char ch = newRes.charAt(i);
            reverseStr = ch+reverseStr;
        }
        if(newRes.equals(reverseStr)){
            return true;
        }else{
            return false;
        }

    }
// ==========================Optimized Code=============Time: 1ms=============
private char toLowerCase(char c) {
    if (c >= 'A' && c <= 'Z') {
        return (char) (c - 'A' + 'a');
    }
    return c;
}

private boolean isLetterOrDigit(char c) {
    return ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9'));
}

public boolean isPalindrome(String s) {

    int left = 0;
    int right = s.length()-1;

    while(left < right){
        char start = toLowerCase(s.charAt(left));
        char end = toLowerCase(s.charAt(right));

        if(!isLetterOrDigit(start)){
            left++;
            continue;
        }

        if(!isLetterOrDigit(end)){
            right--;
            continue;
        }

        if(start != end)
            return false;

        left++;
        right--;

    }

    return true;

    
}
}