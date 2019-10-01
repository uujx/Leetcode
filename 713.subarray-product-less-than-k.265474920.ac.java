class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        
        /* 
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            count = backtracking(count, product, nums, i, k);
        }
        return count;
    }
    
    private int backtracking(int count, int product, int[] nums, int i, int k) {
        if (i < nums.length && product * nums[i] < k) 
            count = backtracking(count+1, product*nums[i], nums, i+1, k);
        return count;
    }
    
    */
        
        int count = 0, prod = 1;
        for (int left = 0, right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (left <= right && prod >= k) {
                prod /= nums[left++];
            }
            // Each step introduces (right - left + 1) subarrays
            count += right - left + 1;
        }
        return count;
    }
}
