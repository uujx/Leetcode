class Solution {
    public int trailingZeroes(int n) {
        // trailing zero means it has a factor of 10
        // 10 has two factors, 2 and 5
        // count how many pairs of (2,5) in factors of n!
        // count how many 5, because 2 is ample
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
}
