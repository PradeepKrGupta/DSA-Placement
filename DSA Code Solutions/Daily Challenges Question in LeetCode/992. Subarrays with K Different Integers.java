// ============================code with runtime of 47ms======================
class Solution {
    public int mostcountfunc(int[] nums, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        int n=nums.length;
        int left=0;
        int right=0;
        int count=0;
        while(right<n){
            map.put(nums[right], map.getOrDefault(nums[right], 0)+1);
            while(map.size()>k){
                map.put(nums[left], map.get(nums[left])-1);
                if(map.get(nums[left])==0){
                    map.remove(nums[left]);
                }
                left++;
            }
            count += right-left+1;
            right++;
        }
        return count;
    }
    

    public int subarraysWithKDistinct(int[] nums, int k) {
        return mostcountfunc(nums, k)-mostcountfunc(nums, k-1);
    }
}


// ======================code with runtime 3ms============================
class Solution {
    public int subarraysWithKDistinct(int[] nums, int K) {
       int[] numFreq = new int[nums.length+1];
       int distinct = 0, start = 0, minEnd = 0, total = 0;
       while (distinct == K || minEnd < nums.length) {
           while (distinct < K && minEnd < nums.length) 
               if (numFreq[nums[minEnd++]]++ == 0) 
               distinct++;
           int maxEnd = minEnd;
           while (maxEnd < nums.length && numFreq[nums[maxEnd]] > 0)
               maxEnd++;
           while (distinct == K) {
               if (numFreq[nums[start++]]-- == 1)
               distinct--;
               total += (maxEnd - minEnd + 1);
           }
       }
       return total;
   }
}