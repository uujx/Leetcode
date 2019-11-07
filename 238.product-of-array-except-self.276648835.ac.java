class Solution {
    public int[] productExceptSelf(int[] nums) {
        // 1. With division - need to consider 0 element
        
        /** 2. Without division - O(n)
        /* 
        int[] L = new int[nums.length], R = new int[nums.length];
        L[0] = 1;
        R[nums.length-1] = 1;
        for (int i = 1; i < nums.length; i++) 
            L[i] = L[i-1] * nums[i-1];
        for (int i = nums.length - 2; i >= 0; i--) 
            R[i] = R[i+1] * nums[i+1];
        
        for (int i = 0; i < nums.length; i++)
            nums[i] = L[i] * R[i];
        
        return nums;
        */
        
        
        // 3. optimization with O(1) space
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) 
            res[i] = res[i-1] * nums[i-1];
        
        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] = res[i] * right;
            right *= nums[i];
        }
        
        return res;
    }
}
