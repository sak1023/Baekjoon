import sys

N = int(sys.stdin.readline())
meeting = [None] * N

for i in range(N):
    time = list(map(int, sys.stdin.readline().split()))
    meeting[i] = time

meeting.sort(key = lambda x: (x[1], x[0]))
count = 1
compare = meeting[0]

for i in range(1, N):
    now = meeting[i]
    
    if compare[1] > now[0]:
        continue
    else:
        compare = now
        count += 1
        
print(count)