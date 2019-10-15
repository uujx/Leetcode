class Solution {
    HashMap<Character, String> map;
    List<String> res = new ArrayList<>();
    
    public List<String> letterCombinations(String digits) {
        if (digits.equals("")) 
            return res;
        
        map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        
        backtracking(digits, 0, "");
        return res;
    }
    
    private void backtracking(String digits, int index, String s) {
        if (index == digits.length()) {
            res.add(s);
        } else {
            for (char ch : map.get(digits.charAt(index)).toCharArray()) {
                backtracking(digits, index+1, s + ch);
            }
        }
    }
}
