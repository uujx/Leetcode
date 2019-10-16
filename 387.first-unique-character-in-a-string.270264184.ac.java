class Solution {
    public int firstUniqChar(String s) {
        /** count and check
        /*
        int[] count = new int[26];
        for (char ch : s.toCharArray()) 
            count[ch - 'a']++;
        
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1)
                return i;
        }
        
        return -1;
        */
        
        int result = s.length();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (s.indexOf(ch) == -1)
                continue;
            if (s.indexOf(ch) == s.lastIndexOf(ch))
                result = Math.min(result, s.indexOf(ch));
        }
        return result == s.length() ? -1 : result;
    }
}
