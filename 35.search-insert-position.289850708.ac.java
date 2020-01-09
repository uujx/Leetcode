class Solution {
    public int searchInsert(int[] nums, int target) {
        int idx = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                idx = i;
                break;
            }
        }
        return idx == -1 ? nums.length : idx;
    }
}
