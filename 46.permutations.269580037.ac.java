class Solution {
    List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> permute(int[] nums) {
        backtracking(new ArrayList(), nums);
        return res;
    }
    
    private void backtracking(List<Integer> tmpList, int[] nums) {
        if (tmpList.size() == nums.length)
            res.add(new ArrayList(tmpList));
        else {
            for (int i = 0; i < nums.length; i++) {
                if (tmpList.contains(nums[i]))
                    continue;
                
                tmpList.add(nums[i]);
                backtracking(tmpList, nums);
                tmpList.remove(tmpList.size() - 1);
            }
        }
    }
}
