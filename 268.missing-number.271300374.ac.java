class Solution {
    public int missingNumber(int[] nums) {
        /** Sorting
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i-1] != 1)
                return nums[i] - 1;
        }
        return nums[0] == 0 ? nums.length : 0;
        */
        
        /* Set
        boolean[] check = new boolean[nums.length+1];
        for (int num : nums)
            check[num] = true;
        for (int i = 0; i < check.length; i++) {
            if (check[i] == false)
                return i;
        }
        return 0;
        */
        
        // Math
        /*
        int expected = nums.length * (nums.length + 1) / 2;
        for (int num : nums)
            expected -= num;
        return expected;
        */
        
        // Bit manupulation
        // XOR is its own inverse
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++)
            missing ^= i ^ nums[i];
        return missing;
        
    }
}
