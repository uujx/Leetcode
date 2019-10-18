class Solution {
    public int findDuplicate(int[] nums) {
        // 1. Brute Force - O(n^2)
        
        // 2. Modify array - O(n)
        
        // 3. Extra memory - boolean[], HashSet - O(n)
        
        /* 4. Sorting - O(nlogn)
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1])
                return nums[i];
        }
        return 0;
        */
        
        // Two Pointers
        int slow, fast;
        slow = fast = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                int start = 0;
                while (start != slow) {
                    start = nums[start];
                    slow = nums[slow];
                }
                return start;
            }
        }
    }
}
