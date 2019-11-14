class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        int i = 0, count = 1;
        while (candies > count) {
            res[i] += count;
            candies -= count;
            count++;
            i = (i+1) % num_people;
        }
        res[i] += candies;
        return res;
    }
}
