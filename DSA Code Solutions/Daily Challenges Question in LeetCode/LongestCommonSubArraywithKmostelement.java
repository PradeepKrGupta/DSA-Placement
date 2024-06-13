// --------------Code using Map-----------------------
class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int count = 0;

        for (int right = 0; right < nums.length; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (map.get(nums[right]) > k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                left++;
            }
            count = Math.max(count, right - left + 1);
        }
        return count;

    }
}

// ----------------Code using without Map---------------
class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        // Assuming the input array contains positive integers only
        int[] frequency = new int[100001]; // Maximum value possible in nums

        int left = 0;
        int count = 1; // Initialize count to 1
        frequency[nums[0]]++;

        for (int right = 1; right < nums.length; right++) {
            frequency[nums[right]]++;

            while (frequency[nums[right]] > k) {
                frequency[nums[left]]--;
                left++;
            }

            count = Math.max(count, right - left + 1);
        }
        return count;
    }
}

