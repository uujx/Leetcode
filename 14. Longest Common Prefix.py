# -*- coding: utf-8 -*-
"""
Created on Sun Dec  2 23:23:05 2018

@author: home
"""
def solution(strs):
    res = ""
    if strs == []:
        return res
    
    i = 0            
    flag = 1
    for char in strs[0]:
        for item in strs:
            try:
                if item[i] != char:
                    flag = 0
            except IndexError:
                flag = 0
        if flag == 1:
            res += char
        else:
            return res
        i += 1
    
    return res

if __name__ == '__main__':
    strs = ['flowers', 'flowe', 'fleew']
    print(solution(strs))
    
    