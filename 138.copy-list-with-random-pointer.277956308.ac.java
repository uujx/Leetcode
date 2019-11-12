/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    HashMap<Node, Node> map = new HashMap<>();
    
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        
        Node cur = new Node(head.val, null, null);
        map.put(head, cur);
        
        cur.next = copyRandomList(head.next);
        cur.random = map.get(head.random);
        
        return cur;
    }
}
