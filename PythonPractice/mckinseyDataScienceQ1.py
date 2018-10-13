#
# Complete the 'max_logs' function below.
#
# The function is expected to return an INTEGER.
# The function accepts following parameters:
#  1. STRING domain
#  2. STRING_ARRAY logs
#
import math
import os
import random
import re
import sys

def max_logs(domain, logs):
    # Write your code here
    logCountDict = {}
    maxDate = ""
    maxCount = 0
    for log in logs:
        if domain not in log:
            continue
        comps = log.split('@', 2);
        date = comps[1][-8:]
        #print(date)
        logCountDict[date] = logCountDict.get(date, 0) + 1
        if logCountDict.get(date) >= maxCount:
            maxCount = logCountDict.get(date)
            maxDate = date
    
    return maxDate

        
if __name__ == '__main__':
    logs = ['user1@organisation1.com20180910',
'user3@organisation1.com20180912',
'user4@organisation1.com20180912',
'user2@organisation2.com20180912',
'user2@organisation1.com20180911',
'user4@organisation2.com20180912',
'user5@organisation2.com20180910',
'user6@organisation2.com20180910',
'user2@organisation1.com20180910']
    domain = 'organisation2.com'
    print(max_logs(domain, logs))