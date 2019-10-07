
class Solution {
    public boolean isAnagram(String s, String t) {
        /** Sorting
        /*
        char[] l1 = s.toCharArray();
        Arrays.sort(l1);
        char[] l2 = t.toCharArray();
        Arrays.sort(l2);
        return Arrays.equals(l1, l2);
        */
        
        // HashTable
        if (s.length() != t.length())
            return false;
        
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        
        for (int i : counter) {
            if (i != 0)
                return false;
        }
        return true;
    }
}
