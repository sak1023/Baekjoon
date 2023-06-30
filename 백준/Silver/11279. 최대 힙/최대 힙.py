import heapq
import sys

N = int(sys.stdin.readline())
hq = []

for i in range(N):
    x = int(sys.stdin.readline())

    if x == 0:
        try:
            print(-heapq.heappop(hq))
        except:
            print(0)
    else:
        heapq.heappush(hq, -x)