class Solution {
    public int titleToNumber(String s) {
        int res = 0;
        int n = s.length() - 1;
        for (char ch : s.toCharArray()) {
            res += (ch - 'A' + 1) * Math.pow(26, n--);
        }
        return res;
    }
}
