class Solution {
    int maxSubstring(String S) {
        // code here
        int[] arr = new int[S.length()];
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='1'){
                arr[i] = -1;
            }else{
                arr[i] = 1;
            }
        }
        
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
            if(sum>max){
                max = sum;
            }
            if(sum<0){
                sum =0;
            }
        }
        
        return max;
    }
}