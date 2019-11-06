class Solution {
    public boolean isPalindrome(String s) {
        /** Two Pointers
        /*
        if (s.length() == 0)
            return true;
        
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            if (Character.isLetterOrDigit(s.charAt(i)) && Character.isLetterOrDigit(s.charAt(j))) {
                if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
                    return false;
                i++;
                j--;
            }
            else if (!Character.isLetterOrDigit(s.charAt(i)) && Character.isLetterOrDigit(s.charAt(j)))
                i++;
            else if (Character.isLetterOrDigit(s.charAt(i)) && !Character.isLetterOrDigit(s.charAt(j)))
                j--;
            else {
                i++;
                j--;
            }
        }
        return true;
        */
        
        
        
        // Regex
        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String rev = new StringBuilder(actual).reverse().toString();
        return actual.equals(rev);
    }
}
