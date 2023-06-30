import sys

def Binary_Search(s, e, A, b):
    while True:
        if s > e:
            return 0
        
        m = (s + e) // 2

        if b == A[m]:
            return 1
        elif b > A[m]:
            s = m + 1
        elif b < A[m]:
            e = m - 1

N = int(sys.stdin.readline())
A = list(map(int, sys.stdin.readline().split()))
M = int(sys.stdin.readline())
B = list(map(int, sys.stdin.readline().split()))

A.sort()

for i in B:
    print(Binary_Search(0, N - 1, A, i))