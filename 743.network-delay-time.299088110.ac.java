class Solution {
    
    class Node {
        int index;
        int distance;
        public Node(int i, int d) {
            index = i;
            distance = d;
        }
    }
    
    public int networkDelayTime(int[][] times, int N, int K) {
        
        Node[] memo = new Node[N];
        for (int i = 0; i < N; i++) {
            memo[i] = new Node(i, Integer.MAX_VALUE);
        }
        memo[K - 1] = new Node(K - 1, 0);
        
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[K - 1] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.distance - n2.distance);
        pq.add(new Node(K - 1, 0));
        
        
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            
            for (int[] edge : times) {
                if (edge[0] - 1 == node.index) {
                    int to = edge[1] - 1;
                    if (dist[node.index] + edge[2] < memo[to].distance) {
                        pq.remove(memo[to]);
                        Node newNode = new Node(to, dist[node.index] + edge[2]);
                        memo[to] = newNode;
                        dist[to] = newNode.distance;
                        pq.add(newNode);                        
                    }
                }
            }
        }
        
        int max = Arrays.stream(dist)
                        .max()
                        .getAsInt();
        return max == 2147483647 ? -1 : max;
    }
}
