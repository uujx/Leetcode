class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        /** Sort
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++)
                list.add(matrix[i][j]);
        }
        
        Collections.sort(list);
        return list.get(k-1);
        */
        
        /** Heap - straightforward
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                pq.add(matrix[i][j]);
                if (pq.size() > k) pq.poll();
            }
        }
        
        return pq.peek();
        */
        
        // Heap - find kth smallest element in m sorted arrays
        class Node {
            int row;
            int col;
            
            public Node(int r, int c) {
                row = r;
                col = c;
            }
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> matrix[n1.row][n1.col] - matrix[n2.row][n2.col]);
        
        // Put the first element of each row into the minHeap, no need to put more than k element
        for (int i = 0; i < k && i < matrix.length; i++)
            pq.add(new Node(i, 0));
        
        // Poll the top min node until the kth, add the next node if the popped node has one
        int count = 0, res = 0;
        while (count < k) {
            Node node = pq.poll();
            if (++count == k) res = matrix[node.row][node.col];
            if (++node.col < matrix[0].length) pq.add(node);
        }
        return res;
    }
}
