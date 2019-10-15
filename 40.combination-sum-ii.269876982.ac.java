class Solution {
    List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates, new ArrayList(), target, 0);
        return res;
    }
    
    private void backtracking(int[] nums, List<Integer> tmpList, int remain, int start) {
        if (remain < 0)
            return;
        if (remain == 0) {
            res.add(new ArrayList(tmpList));
            return;
        } 
        
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i-1])
                continue;
            if (remain - nums[i] < 0)
                break;
            
            tmpList.add(nums[i]);
            backtracking(nums, tmpList, remain - nums[i], i+1);
            tmpList.remove(tmpList.size() - 1);
            
        }
    }
}
