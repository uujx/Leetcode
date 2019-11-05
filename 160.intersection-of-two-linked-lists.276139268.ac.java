/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        /** HashSet
        /*
        HashSet<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        
        while (headB != null) {
            if (set.contains(headB))
                return headB;
            headB = headB.next;
        }
        
        return null;
        */
        
        
        // Two Pointers
        if (headA == null || headB == null)
            return null;
        
        ListNode a = headA;
        ListNode b = headB;
        // Let a and b travel the same length of len(a) + len(b)
        // If there is an intersection, then the meeting point is the ans
        // If no intersection, since they both travel the same length, they will reach null at the same time(a == b == null) to break the loop
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        
        return a;
    }
}
