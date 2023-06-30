import sys

paper = [[0 for _ in range(101)] for _ in range(101)]

N = int(sys.stdin.readline())

for i in range(N):
    y, x = map(int, sys.stdin.readline().split())
    
    for j in range(y, y + 10):
        for k in range(x, x + 10):
            paper[j][k] = 1
        
answer = 0
    
for i in paper:
    for j in i:
        answer += j
        
print(answer)