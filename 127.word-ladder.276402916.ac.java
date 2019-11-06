class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord))
            return 0;
        
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        HashMap<String, Integer> map = new HashMap<>();
        map.put(beginWord, 1);
        
        while (!q.isEmpty()) {
            String word = q.poll();
            if (word.equals(endWord))
                return map.get(word);
            
            for (String candi : wordList) {
                if (!map.containsKey(candi) && check(word, candi)) {
                    map.put(candi, map.get(word) + 1);
                    q.add(candi);
                }
            }
        }
        
        return 0;
    }
    
    private boolean check(String a, String b) {
        int count = 0;
        for (int i = 0, j = 0; i < a.length(); i++, j++) {
            if (a.charAt(i) != b.charAt(j)) {
                if (count > 0) return false;
                count++;
            }
        }
        return true;
    }
}
