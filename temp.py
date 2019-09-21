# -*- coding: utf-8 -*-
"""
Created on Thu Dec 13 00:24:08 2018

@author: home
"""

def temp(n = 0):
    print(n)
    if n < 10:
        temp(n+1)
        return

temp()