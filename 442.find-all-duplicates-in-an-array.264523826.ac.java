class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        /** HashSet
        /*
        List<Integer> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.contains(num))
                set.add(num);
            else 
                res.add(num);
        }
        return res;
        */
        
        LinkedList<Integer> res = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0)
                res.add(Math.abs(nums[i]));
            nums[index] = -nums[index];
        }
        
        return res;
    }
}
