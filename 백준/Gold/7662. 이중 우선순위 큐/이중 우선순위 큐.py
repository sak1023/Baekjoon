import heapq
import sys

T = int(sys.stdin.readline())

for _ in range(T):
    k = int(sys.stdin.readline())
    asc = []
    desc = []
    check = [False for _ in range(k)]

    for i in range(k):
        operation, n = sys.stdin.readline().split()
        n = int(n)

        if operation == 'I':
            heapq.heappush(asc, [n, i])
            heapq.heappush(desc, [-n, i])
        else:
            if n == 1:
                while desc and check[desc[0][1]]:
                    heapq.heappop(desc)
                if desc:
                    check[heapq.heappop(desc)[1]] = True
            else:
                while asc and check[asc[0][1]]:
                    heapq.heappop(asc)
                if asc:
                    check[heapq.heappop(asc)[1]] = True

    if desc and asc:
        while desc and check[desc[0][1]]:
            heapq.heappop(desc)
        while asc and check[asc[0][1]]:
            heapq.heappop(asc)
        if desc and asc:
            print(-desc[0][0], asc[0][0])
        else:
            print("EMPTY")
    else:
        print("EMPTY")