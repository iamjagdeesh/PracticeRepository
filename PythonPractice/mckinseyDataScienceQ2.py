import math
import os
import random
import re
import sys

#
# Complete the 'mean' function below.
#
# The function is expected to return an INTEGER_ARRAY.
# The function accepts 2D_INTEGER_ARRAY two_d_array as parameter.
#

def mean(two_d_array):
    res = []
    for i in range(0, len(two_d_array)):
        sum = 0
        for j in range(0, len(two_d_array[i])):
            sum += two_d_array[i][j]
        mean = sum / len(two_d_array[i])
        res.append(mean)
    
    return res

if __name__ == '__main__':