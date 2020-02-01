class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        
        int[] stops = new int[n];
        Arrays.fill(stops, Integer.MAX_VALUE);
        stops[src] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        pq.add(new int[]{src, 0, 0});
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            
            int u = cur[0], du = cur[1], su = cur[2];
            if (u == dst) return dist[u];
            if (su == K + 1) continue;
            
            for (int[] flight : flights) {
                if (flight[0] == u) {
                    int v = flight[1], dv = du + flight[2], sv = su + 1;
                    
                    if (dv < dist[v]) {
                        dist[v] = dv;
                        pq.add(new int[]{v, dv, sv});
                    } else if (sv < stops[v]) {
                        stops[v] = sv;
                        pq.add(new int[]{v, dv, sv});
                    }
                }
            }
        }
        
        return -1;
    }
}
