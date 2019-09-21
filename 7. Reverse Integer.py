# -*- coding: utf-8 -*-
"""
Created on Tue Oct 23 23:50:57 2018

@author: home
"""
def reverseInteger(x):
    """
    if x < -231 or x > 230:
        return 0
    
    digit = []
    temp = x
    while temp != 0:
        digit.append(temp % 10)
        temp = temp // 10
    
    times = len(digit)
    res = 0
    for e in digit:
         res += e * (10 ** (times - 1))
         times -= 1
    
    if x >= 0:
        return res
    else:
        res = -res
        return res
    """
    
    if x < -231 or x > 230:
            return 0
    
    digits = len(str(abs(x)))
    temp = abs(x)
    res = 0
    while digits != 0:
        res += (temp % 10) * (10 ** (digits-1))
        temp = temp // 10
        digits -= 1
    
    return res if x >= 0 else -res
    
if __name__ == '__main__':
    x = int(input())
    print(reverseInteger(x))