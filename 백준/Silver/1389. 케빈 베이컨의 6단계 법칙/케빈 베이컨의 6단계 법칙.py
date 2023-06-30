from collections import deque
import sys

def BFS():
    result = []

    for root in range(N):
        check = [0 for _ in range(N)]
        check[root] = 1
        dq = deque()
        dq.append(root)

        while dq:
            node = dq.popleft()
            for i in people[node]:
                if check[i] == 0:
                    check[i] = check[node] + 1
                    dq.append(i)

        result.append(sum(check) - N)

    return result.index(min(result)) + 1

N, M = map(int, sys.stdin.readline().split())

people = [[] for _ in range(N)]

for i in range(M):
    A, B = map(int, sys.stdin.readline().split())

    people[A - 1].append(B - 1)
    people[B - 1].append(A - 1)

print(BFS())