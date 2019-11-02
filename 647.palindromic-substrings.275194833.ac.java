class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += extendPalindrome(s, i, i) + extendPalindrome(s, i, i+1);
        }
        return count;
    }
    
    private int extendPalindrome(String s, int i, int j) {
        int count = 0;
        for (; i >= 0 && j < s.length(); i--, j++) {
            if (s.charAt(i) == s.charAt(j))
                count++;
            else 
                break;
        }
        return count;
    }
}
