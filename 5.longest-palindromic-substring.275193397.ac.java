class Solution {
    public String longestPalindrome(String s) {
        // 1. Brute Force: O(n^3)
        //    Try every start and end point, and test if it is palindrome
        
        // 2. DP
        int max = 0, idx = 0;
        int len = s.length();
        if (len < 2)
            return s;
        
        for (int i = 0; i < len; i++) {
            int len1 = extendPalindrome(s, i, i), len2 = extendPalindrome(s, i, i+1);
            if (max < Math.max(len1, len2)) {
                idx = (len1 > len2) ? (i - len1/2) : (i - len2/2 + 1);
                max = len1 > len2 ? len1 : len2;
            }
        }
        
        return s.substring(idx, idx + max);
    }
    
    private int extendPalindrome(String s, int i, int j) {
        for (; i >= 0 && j < s.length(); i--, j++) {
            if (s.charAt(i) != s.charAt(j))
                break;
        }
        return j - i - 2 + 1; // 2 means two unmatched characters
    }
}
