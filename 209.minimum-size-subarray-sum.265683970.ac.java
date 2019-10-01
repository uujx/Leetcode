class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0, right = 0;
        int sum = 0;
        int len = 0;
        while ( right < nums.length ) {
            if (sum + nums[right] < s) {
                sum += nums[right++];
            } else {
                if (len == 0 || right-left+1 < len)
                    len = right - left + 1;
                sum -= nums[left++];
            }
        }
        return len;
    }
}
