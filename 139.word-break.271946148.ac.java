class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        /** dfs - time limit exceed
        String now = "";
        for (int i = 0; i < s.length(); i++) {
            now += s.charAt(i);
            if (wordDict.contains(now)) {
                if (i == s.length() - 1)
                    return true;
                else if (wordBreak(s.substring(i+1), wordDict))
                    return true;
            }
        }
        return false;
        */
        
        // dp
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
    
}
