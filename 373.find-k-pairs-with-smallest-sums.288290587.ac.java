class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        class Node {
            int i;
            int j;
            Node(int i, int j) {
                this.i = i;
                this.j = j;
            }
        }
        
        if (nums1.length == 0 || nums2.length == 0) return new ArrayList<>();
        
        List<List<Integer>> res = new LinkedList<>();
        PriorityQueue<Node> minheap = new PriorityQueue<>((n1, n2) -> nums1[n1.i] + nums2[n1.j] - nums1[n2.i] - nums2[n2.j]);
        
        for (int i = 0; i < nums1.length && i < k; i++) 
            minheap.add(new Node(i, 0));
        
        for (int count = 0; count < k && !minheap.isEmpty(); count++) {
            Node node = minheap.poll();
            List<Integer> el = new ArrayList<>();
            el.add(nums1[node.i]);
            el.add(nums2[node.j]);
            res.add(el);
            
            if (++node.j < nums2.length)
                minheap.add(node);
        }
        return res;
    }
}
