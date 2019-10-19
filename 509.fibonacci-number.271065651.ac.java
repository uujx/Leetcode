class Solution {
    public int fib(int N) {
        if (N == 1 || N == 2)
            return 1;
        int first = 1;
        int second = 1;
        int now = 0;
        for (int i = 3; i <= N; i++) {
            now = first + second;
            first = second;
            second = now;
        }
        
        return now;
            
    }
}
