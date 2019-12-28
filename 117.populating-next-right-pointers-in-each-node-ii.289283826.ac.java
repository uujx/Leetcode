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
        if (root == null) return null;
        
        Node cur = root, nextLevel = new Node();
        Node p = nextLevel;
        
        while (cur != null) {
            if (cur.left != null) {
                p.next = cur.left;
                p = p.next;
            }
            if (cur.right != null) {
                p.next = cur.right;
                p = p.next;
            }
            if (cur.next != null) cur = cur.next;
            else {
                cur = nextLevel.next;
                nextLevel.next = null;
                p = nextLevel;
            }
        }
        return root;
    }
}
