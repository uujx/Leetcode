class Solution {
    List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtracking(new ArrayList(), nums, 0);
        return res;
    }
    
    private void backtracking(List<Integer> tmpList, int[] nums, int start) {
        res.add(new ArrayList(tmpList));
        
        for (int i = start; i < nums.length; i++) {
            // Skip duplicates!!!
            if (i > start && nums[i] == nums[i-1]) 
                continue;
            
            tmpList.add(nums[i]);
            backtracking(tmpList, nums, i+1);
            tmpList.remove(tmpList.size() - 1);
        }
    }
}
