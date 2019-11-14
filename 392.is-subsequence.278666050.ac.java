class Solution {
    public boolean isSubsequence(String s, String t) {
        /** Two pointer
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        if (i < s.length()) return false;
        return true;
        */
        
        // Binary Search
        if (s.length() == 0) return true;
        else if (t.length() == 0) return false;
        
        int index = t.indexOf(s.charAt(0));
        if (index >= 0) 
            return isSubsequence(s.substring(1), t.substring(index+1));
        else 
            return false;
    }

}
