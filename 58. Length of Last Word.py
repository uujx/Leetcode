# -*- coding: utf-8 -*-
"""
Created on Sun Dec  9 20:28:13 2018

@author: home
"""

"""
Solution 1

if ' ' not in s:
    return len(s)

i = len(s) - 1
count = 0
flag1, flag2 = 0, 0
while flag1 != 1 or flag2 != 1:
    if i < 0:
        break
    if s[i] != ' ':
        count += 1
        flag1 = 1
    if flag1 == 1 and s[i] == ' ':
        flag2 = 1
    
    i -= 1
        
return count
"""

if ' ' not in s:
    return len(s)

return len(s.split()[-1]) if s.split() != [] else 0