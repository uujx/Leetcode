# -*- coding: utf-8 -*-
"""
Created on Fri Dec 14 21:44:22 2018

@author: home
"""

def nextGreaterElement(nums1, nums2):
    """
    :type nums1: List[int]
    :type nums2: List[int]
    :rtype: List[int]
    """
    res = []
    for n1 in nums1:
        flag = 1
        for n2 in nums2[nums2.index(n1) + 1:]:
            if n2 > n1:
                res.append(n2)
                flag = 0
                break
        
        if flag == 1:
            res.append(-1)
        
    return res

nums1 = [4,1,2]
nums2 = [1,3,4,2]
print(nextGreaterElement(nums1, nums2))
            