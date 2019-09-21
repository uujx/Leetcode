# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def mergeTwoLists(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        # if l1==None and l2==None:
        #     return None
        
        # new = ListNode(0)
        # res = new
        # while l1!=None or l2!=None:
        #     if l1!=None:
        #         new.next = l1
        #         new = new.next
        #     if l2!=None:
        #         new.next = l2
        #         new = new.next
        #     if l1!=None:
        #         l1 = l1.next
        #     if l2!=None:
        #         l2 = l2.next
        
        # return res.next

        if l1 == None : return l2
        if l2 == None : return l1
        
        if l1.val <= l2.val:
            l1.next = self.mergeTwoLists(l1.next, l2)
            return l2
        else:
            l2.next = self.mergeTwoLists(l1, l2.next)
            return l1
        