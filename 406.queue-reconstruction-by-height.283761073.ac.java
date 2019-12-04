class Solution {
    public int[][] reconstructQueue(int[][] people) {
        /* My solution
        Arrays.sort(people, (a, b) -> a[0] - b[0]);
        
        boolean[] used = new boolean[people.length];
        int[][] res = new int[people.length][2];
        for (int i = 0; i < people.length; i++) {
            int cnt = people[i][1], idx = 0;
            while (cnt != 0 || used[idx]) {
                if (cnt != 0) {
                    if (!used[idx]) 
                        cnt--;
                    else if (res[idx][0] >= people[i][0]) 
                        cnt--;
                }
                
                idx++;
            }
            res[idx][0] = people[i][0];
            res[idx][1] = people[i][1];
            used[idx] = true;
        }
        
        return res;
        */
        
        // tallest first
        Arrays.sort(people, (a, b) -> a[0] != b[0] ? b[0] - a[0] : a[1] - b[1]);
        LinkedList<int[]> res = new LinkedList<>();
        for (int[] cur : people)
            res.add(cur[1], cur);
        return res.toArray(new int[people.length][2]);
    }
}
