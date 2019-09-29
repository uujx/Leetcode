class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        backtracking(res, tempList, nums, 0);
        return res;
    }
    
    private void backtracking(List<List<Integer>> res, List<Integer> tempList, int[] nums, int start) {
        res.add(new ArrayList(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtracking(res, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
