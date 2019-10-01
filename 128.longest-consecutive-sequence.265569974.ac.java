class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) 
            set.add(nums[i]);
        
        int maxCount = 0;
        for (int num : set) {
            if (!set.contains(num-1)) {
                int curNum = num;
                int count = 0;
                while (set.contains(curNum++)) 
                    count++;
                
                if (count > maxCount)
                maxCount = count;
            }
        }
        
        return maxCount;
    }
}
