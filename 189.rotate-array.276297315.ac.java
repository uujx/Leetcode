class Solution {
    public void rotate(int[] nums, int k) {
        /** mod
        /*
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int candi = (i + k) % nums.length;
            res[candi] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = res[i];
        }
        */
        
        
        // In place
        k %= nums.length;
        int count = 0;
        for (int i = 0; count < nums.length; i++) {
            int last = nums[i];
            int current = i;
            do {
                int index = (current + k) % nums.length;
                int tmp = nums[index];
                nums[index] = last;
                current = index;
                last = tmp;
                count++;
            } while (current != i);
        }
    }
}
