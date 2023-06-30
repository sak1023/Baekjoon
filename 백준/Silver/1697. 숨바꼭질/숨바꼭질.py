from collections import deque
import sys

N, K = map(int, sys.stdin.readline().split())

dq = deque([N])
count = [0] * 100001

while dq:
    node = dq.popleft()
    
    if node == K:
        print(count[node])
        break
    
    for i in (node - 1, node + 1, node * 2):
        if 0 <= i <= 100000 and count[i] == 0:
            count[i] = count[node] + 1
            dq.append(i)