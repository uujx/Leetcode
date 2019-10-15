class Solution {
    List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates, target, new ArrayList(), 0);
        return res;
    }
    
    private void backtracking(int[] candi, int remain, List<Integer> tmpList, int start) {
        if (remain == 0) {
            res.add(new ArrayList(tmpList));
            return;
        }
        
        for (int i = start; i < candi.length; i++) {
            if (remain - candi[i] < 0)
                break;
            
            tmpList.add(candi[i]);
            backtracking(candi, remain - candi[i], tmpList, i);
            tmpList.remove(tmpList.size() - 1);
        }
    }
}
