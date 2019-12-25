class Solution {
    public void sortColors(int[] nums) {
        /** Tow pass - counting sort
        int[] count = new int[3];
        for (int num : nums)
            count[num]++;
        for (int i = 0, j = 0; i < nums.length; i++) {
            while (count[j] == 0) j++;
            nums[i] = j;
            count[j]--;
        }
        */
        
        
        // One pass - O(1) space
        // Maintain two pointers low and high, el left to low are all 0, el right to high are all 2, el between left and high are all 1
        if (nums.length == 0) return;
        int low = 0, high = nums.length - 1;
        int i = 0;
        while (i <= high) {
            if (nums[i] == 0) {
                int tmp = nums[i];
                nums[i] = nums[low];
                nums[low] = tmp;
                i++;
                low++;
            } else if (nums[i] == 2) {
                int tmp = nums[i];
                nums[i] = nums[high];
                nums[high] = tmp;
                high--;
            } else i++;
        }
    }
}
