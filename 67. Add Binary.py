# -*- coding: utf-8 -*-
"""
Created on Mon Dec 10 21:09:18 2018

@author: home
"""

def solution(a, b):
    i = len(a) - 1
    j = len(b) - 1
    s = ''
    flag = 0
    while i >= 0 or j >= 0 or flag == 1:
        if flag == 0:
            if i >= 0 and j >= 0:
                tempSum = int(a[i]) + int(b[j])
            else:
                tempSum = int(b[j]) if i < 0 else int(a[i])
        else:
            if i >= 0 and j >= 0:
                tempSum = int(a[i]) + int(b[j]) + 1
            elif i >=0 or j >= 0:
                tempSum = int(b[j]) + 1 if i < 0 else int(a[i]) + 1
            else:
                tempSum = 1
            flag = 0
            
        if tempSum == 0:
        s += '0'
        elif tempSum == 1:
            s += '1'
        elif tempSum == 2:
            flag = 1
            s += '0'
        elif tempSum == 3:
            flag = 1
            s += '1'
        
        i -= 1
        j -= 1
                
    return s[::-1]


if __name__ == "__main__":
    a = '1'
    b = '111'
    print(solution(a, b))




