class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] sortedChar = str.toCharArray();
            Arrays.sort(sortedChar);
            String sortedStr = new String(sortedChar);
            
            if (!map.containsKey(sortedStr))
                map.put(sortedStr, new LinkedList<>());
            map.get(sortedStr).add(str);
        }
        
        return new LinkedList(map.values());
    }
}
