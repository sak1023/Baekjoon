import sys

N, M = map(int, sys.stdin.readline().split())
tree = list(map(int, sys.stdin.readline().split()))
s, e = 0, max(tree)

def Binary_Search(s, e):
    while 1:
        m = (s + e) // 2
        sum = 0
        
        for i in tree:
            if i > m:
                sum += i - m
        if sum == M or s > e:
            print(m)
            break
        elif sum >= M:
            s = m + 1
        else:
            e = m - 1

Binary_Search(s, e)