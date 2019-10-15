class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        /** boolean[] to track unique element
        /*
        boolean[] appeared = new boolean[nums.length+1];
        for (int num : nums) 
            appeared[num] = true;
        
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < appeared.length; i++) {
            if (!appeared[i])
                res.add(i);
        }
        
        return res;
        */
        
        for (int i = 0; i < nums.length; i++) {
            int newIndex = Math.abs(nums[i]) - 1;
            if (nums[newIndex] < 0)
                continue;
            else 
                nums[newIndex] *= -1;
        }
        
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i+1);
            }
        }
        
        return res;
    }
}
