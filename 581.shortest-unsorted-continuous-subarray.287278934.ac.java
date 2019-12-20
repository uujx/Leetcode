class Solution {
    public int findUnsortedSubarray(int[] nums) {
        // 1. sorting - sort the copy of nums and compare the elements to find the first and last different entries
        
        // 2. stack - two passes to find the correct places for the minimum and maximum misplaced elements
//         Stack<Integer> s = new Stack<>();
//         int l = nums.length, r = 0;
//         for (int i = 0; i < nums.length; i++) {
//             while (!s.isEmpty() && nums[s.peek()] > nums[i])
//                 l = Math.min(l, s.pop());
//             s.push(i);
//         }
        
//         s.clear();
//         for (int i = nums.length - 1; i >= 0; i--) {
//             while (!s.isEmpty() && nums[s.peek()] < nums[i])
//                 r = Math.max(r, s.pop());
//             s.push(i);
//         }
        
//         return r - l > 0 ? r - l + 1 : 0;
        
        
        // 3. one pass - find the misplaced element that is smaller than the max value so far or greater than the min value so far, keep updating this so as to find the leftmost and rightmost element
        int n = nums.length;
        int min = nums[n-1], max = nums[0], start = -1, end = -2;
        for (int i = 1; i < n; i++) {
            max = Math.max(nums[i], max);
            min = Math.min(nums[n-1-i], min);
            if (nums[i] < max) end = i;
            if (nums[n-1-i] > min) start = n-1-i;
        }
        return end - start + 1;
    }
}
