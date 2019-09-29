/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        /** Using aux array to store all the even nodes
        /*
        if (head == null)
            return head;
        
        LinkedList<Integer> aux = new LinkedList<>();
        ListNode res = head;
        boolean flag = false;
        ListNode prev = head;
        while (head != null) {
            if (!flag) {
                prev = head;
            } else {
                aux.add(head.val);
                prev.next = head.next;
            }
            
            flag = !flag;
            head = head.next;
        }
        
        head = res;
        while (head.next != null)
            head = head.next;
        
        while (!aux.isEmpty()) {
            ListNode node = new ListNode(aux.poll());
            head.next = node;
            head = node;
        }
        
        return res;
        */
        
        
        // In-place solution
        // seperate the list into two lists, an odd one and an even one
        // then join them together.
        if (head == null)
            return head;
        
        ListNode node = new ListNode(0);
        ListNode evenList = node;
        ListNode res = head;
        
        int count = 1;
        ListNode prev = head;
        while (head.next != null) {
            if (count % 2 == 1){
                prev = head;
            } else {
                prev.next = head.next;
                node.next = head;
                node = head;
                // node.next = null;
            }
            
            count++;
            head = head.next;
            node.next = null;
        }
        
        if (count % 2 == 0) {
            node.next = head;
            head.next = null;
            prev.next = evenList.next;
        } else {
            head.next = evenList.next;
        }
        
        return res;
    }
}
