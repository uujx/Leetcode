/** HashMap 
/* 
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for (int num : nums) {
            if (hashmap.containsKey(num)) {
                hashmap.put(num, hashmap.get(num) + 1);
            } else {
                hashmap.put(num, 1);
            }
        }
        
        backtracking(new ArrayList(), hashmap);
        return res;
    }
    
    private void backtracking(List<Integer> tmpList, HashMap<Integer, Integer> hashmap) {
        boolean flag = false;
        for (int i : hashmap.values()) {
            if (i != 0)
                flag = true;
        }
                
        if (!flag)
            res.add(new ArrayList(tmpList));
        else {
            for (int num : hashmap.keySet()) {
                if (hashmap.get(num) == 0)
                    continue;
                tmpList.add(num);
                hashmap.put(num, hashmap.get(num) - 1);
                
                backtracking(tmpList, hashmap);
                
                tmpList.remove(tmpList.size() - 1);
                hashmap.put(num, hashmap.get(num) + 1);
                
            }
        }
    }
}
*/


// Use an used array to skip duplicates
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        backtracking(new ArrayList(), nums, new boolean[nums.length]);
        return res;
    }
    
    private void backtracking(List<Integer> tmpList, int[] nums, boolean[] used) {
        if (tmpList.size() == nums.length)
            res.add(new ArrayList(tmpList));
        
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || i > 0 && nums[i] == nums[i-1] && !used[i-1]) 
                continue;
            
            used[i] = true;
            tmpList.add(nums[i]);
            
            backtracking(tmpList, nums, used);
            
            used[i] = false;
            tmpList.remove(tmpList.size() - 1);
        }
    }
}
