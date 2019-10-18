class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) 
            map.put(num, map.getOrDefault(num, 0) + 1);
        
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> map.get(n1) - map.get(n2));
        for (int num : map.keySet()) {
            heap.add(num);
            if (heap.size() > k)
                heap.poll();
        }
        
        List<Integer> res = new ArrayList<>();
        while (!heap.isEmpty()) {
            res.add(heap.poll());
        }
        Collections.reverse(res);
        return res;
    }
}
