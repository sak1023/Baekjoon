from collections import deque
import sys

def BFS():
    dq = deque([1])
    check[0] = False
    count = -1
    
    while dq:
        n = dq.popleft()
        count += 1
        
        for i in com[n - 1]:
            if check[i - 1]:
                dq.append(i)
                check[i - 1] = False
                
    return print(count)
        
N = int(sys.stdin.readline())
M = int(sys.stdin.readline())

com = [[] for _ in range(N)]
check = [True for _ in range(N)]

for i in range(M):
    s, e = map(int, sys.stdin.readline().split())
    com[s - 1].append(e)
    com[e - 1].append(s)
    
BFS()