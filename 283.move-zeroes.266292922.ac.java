class Solution {
    public void moveZeroes(int[] nums) {
        /** In-place solution, backward
        /*
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                for (int j = i+1; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        int tmp = nums[j];
                        nums[j] = nums[j-1];
                        nums[j-1] = tmp;
                    } else {
                        break;
                    }
                }
            }
        }
        */
        
        // Alternative approach, move all non-zero to the front
        int lastFoundNonZeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastFoundNonZeroIndex++] = nums[i];
            }
        }
        
        for (int i = lastFoundNonZeroIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
