from collections import deque
import sys


def DFS(v):
    check[v] = False
    print(v, end=" ")

    for i in range(1, N + 1):
        if check[i] and graph[v][i]:
            DFS(i)


def BFS():
    array = deque([V])
    check[V] = False

    while array:
        v = array.popleft()
        print(v, end=" ")

        for i in range(1, N + 1):
            if check[i] and graph[v][i]:
                array.append(i)
                check[i] = False


N, M, V = map(int, sys.stdin.readline().split())

graph = [[False for _ in range(N + 1)] for _ in range(N + 1)]
nodes = []

for _ in range(M):
    s, e = map(int, sys.stdin.readline().split())
    graph[s][e] = True
    graph[e][s] = True

check = [True for _ in range(N + 1)]

DFS(V)

print()
check = [True for _ in range(N + 1)]

BFS()