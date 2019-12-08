class Solution {
    public int leastInterval(char[] tasks, int n) {
        // the task with max number should be done first
        int[] memo = new int[26];
        for (char task : tasks)
            memo[task - 'A']++;
        
        Arrays.sort(memo);
        int count = 0;
        while (memo[25] > 0) {
            int i = 0;
            while (i <= n) {
                if (memo[25] == 0) break;
                if (i < 26 && memo[25 - i] > 0)
                    memo[25 - i]--;
                
                count++;
                i++;
            }
            Arrays.sort(memo);
        }
        return count;
    }
}
