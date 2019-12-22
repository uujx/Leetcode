class Solution {
    public int arrayNesting(int[] nums) {
        boolean[] used = new boolean[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            
            int cur = i, count = 0;
            while (!used[cur]) {
                used[cur] = true;
                cur = nums[cur];
                count++;
            }
            max = Math.max(count, max);
        }
        return max;
    }
}
