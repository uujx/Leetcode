/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        /** Using Queue - level traversal
        if (root == null) return null;
        
        Queue<Node> q = new LinkedList<>();
        int cur = 0, count = 1;
        q.add(root);
        
        while (!q.isEmpty()) {
            Node node = q.poll();
            if (++cur == count) {
                cur = 0;
                count *= 2;
            } else {
                node.next = q.peek();
            }
            
            if (node.left != null) q.add(node.left);
            if (node.right != null) q.add(node.right);
        }
        
        return root;
        */
        
        
        // O(1) space
        if (root == null) return null;
        
        Node pre = root, cur = null;
        while (pre.left != null) {
            cur = pre;
            while (cur != null) {
                cur.left.next = cur.right;
                if (cur.next != null) cur.right.next = cur.next.left;
                cur = cur.next;
            }
            pre = pre.left;
        }
        return root;
    }
}
