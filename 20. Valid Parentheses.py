# -*- coding: utf-8 -*-
"""
Created on Fri Dec  7 00:32:20 2018

@author: home
"""
def solution(s):
    if s == '':
        return True
    
    if len(s) % 2 == 1:
        return False
    else:
        xiaoL = '('
        xiaoR = ')'
        zhongL = '['
        zhongR = ']'
        daL = '{'
        daR = '}'
        mid = int(len(s)/2)
        left = s[0 : mid]
        right = s[mid:]
        
        if xiaoL in right or zhongL in right or daL in right:
            return False
        else:
            right = right.replace(xiaoR, xiaoL)
            right = right.replace(zhongR, zhongL)
            right = right.replace(daR, daL)
        
            if left == right:
                return True
            else: 
                return False
            
if __name__ == "__main__":
    s = '([])'
    print(solution(s))