class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashMap<String, Integer> map = new HashMap<>();
//        PriorityQueue<String> pq = new PriorityQueue<>((s1, s2) -> map.get(s2) - map.get(s1));
        List<String> banList = Arrays.asList(banned);

        // Preprocess string
        String[] words = paragraph.replaceAll("\\W+", " ").toLowerCase().split("\\s+");
        String max = "";

        for (String word : words) {
            if (!banList.contains(word)) {
                map.put(word, map.getOrDefault(word, 0) + 1);
//                pq.add(word);
                if (max.equals("")) {
                    max = word;
                } else if (map.get(word) > map.get(max))
                    max = word;
            }
        }
        
        return max;
        
        
    }
}
