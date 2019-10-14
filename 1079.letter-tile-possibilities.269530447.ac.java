class Solution {
    public int numTilePossibilities(String tiles) {
        int[] count = new int[26];
        for (char ch : tiles.toCharArray()) count[ch - 'A']++;
        return backtracking(count);
    }
    
    private int backtracking(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0)
                continue;
            
            sum++;
            arr[i]--;
            sum += backtracking(arr);
            arr[i]++;
        }
        return sum;
    }
}
