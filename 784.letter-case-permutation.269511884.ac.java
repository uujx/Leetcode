class Solution {
    List<String> res = new ArrayList<>();
    
    public List<String> letterCasePermutation(String S) {
        backtracking(S.toCharArray(), 0);
        return res;
    }
    
    private void backtracking(char[] chars, int index) {
        if (index == chars.length) {
            res.add(new String(chars));
            return;
        }
        
        if (Character.isDigit(chars[index])) {
            backtracking(chars, index+1);
        } else if (Character.isLetter(chars[index])) {
            chars[index] = Character.toLowerCase(chars[index]);
            backtracking(chars, index+1);
            chars[index] = Character.toUpperCase(chars[index]);
            backtracking(chars, index+1);
        }
    }
}
