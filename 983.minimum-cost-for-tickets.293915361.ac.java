class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        /* Track the whole calender year till the end of the travel day
        // f[i] = min(f[i-1] + costs[0], f[i-7] + costs[1], f[i-30] + costs[1])
        List<Integer> dayList = new ArrayList<>(days.length);
        for (int day : days) dayList.add(day);
        int[] f = new int[days[days.length-1] + 1];
        f[0] = 0;
        for (int i = 1; i < f.length; i++) {
            if (!dayList.contains(i)) f[i] = f[i-1];
            else f[i] = Math.min(f[i-1] + costs[0], Math.min(f[Math.max(0, i-7)] + costs[1], f[Math.max(0, i-30)] + costs[2]));
        }
        return f[f.length - 1];
        */
        
        // Track only the travel days
        Queue<int[]> last7 = new LinkedList<>();
        Queue<int[]> last30 = new LinkedList<>();
        int cost = 0;
        for (int day : days) {
            while (!last7.isEmpty() && last7.peek()[0] + 7 <= day) last7.poll();
            while (!last30.isEmpty() && last30.peek()[0] + 30 <= day) last30.poll();
            last7.add(new int[]{day, cost + costs[1]});
            last30.add(new int[]{day, cost + costs[2]});
            cost = Math.min(cost + costs[0], Math.min(last7.peek()[1], last30.peek()[1]));
        }
        return cost;
    }
}
