class Solution {
    public int lengthOfLongestSubstring(String s) {
        /** Set
        /*
        Set<Character> set = new HashSet<>();
        int max = 0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));       
                max = Math.max(max, j - i + 1);
            } else {
                while (set.contains(s.charAt(j))) {
                    set.remove(s.charAt(i));
                    i++;
                }
                set.add(s.charAt(j));
            }
        }
        return max;
        */
        
        
        // Map
        // store (char, index) mappings to pinpoint the duplicate location
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j)))
                i = Math.max(map.get(s.charAt(j)), i);
            max = Math.max(max, j - i + 1);
            map.put(s.charAt(j), j+1);
                
        }
        return max;
    }
}
