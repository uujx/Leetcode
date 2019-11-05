class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        /** Brute Force
        /*
        List<String> res = new LinkedList<>();
        List<String> b = Arrays.asList(list2);
        int minIdx = Integer.MAX_VALUE;
        
        for (int i = 0; i < list1.length; i++) {
            int indexB = b.indexOf(list1[i]);
            if (indexB != -1 && i + indexB <= minIdx) {
                if (i + indexB < minIdx) {
                    res.clear();
                    minIdx = i + indexB;
                }
                res.add(list1[i]);
            }
        }
        return res.toArray(new String[0]);
        */
        
        
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++)
            map.put(list1[i], i);
        
        int min = Integer.MAX_VALUE;
        List<String> res = new LinkedList<>();
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i]) && map.get(list2[i]) + i <= min) {
                if (map.get(list2[i]) + i < min) {
                    res.clear();
                    min = map.get(list2[i]) + i;
                }
                res.add(list2[i]);
            }
        }
        
        return res.toArray(new String[0]);
    }
}
