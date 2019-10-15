class Solution {
    List<List<String>> res = new ArrayList<>();
    
    public List<List<String>> partition(String s) {
        backtracking(s, new ArrayList(), 0);
        return res;
    }
    
    private void backtracking(String s, List<String> tmpList, int start) {
        if (start == s.length())
            res.add(new ArrayList(tmpList));
        
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                tmpList.add(s.substring(start, i+1));
                backtracking(s, tmpList, i+1);
                tmpList.remove(tmpList.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String s, int low, int high) {
        while (low < high) 
            if (s.charAt(low++) != s.charAt(high--)) return false;
        return true;
    }
}
