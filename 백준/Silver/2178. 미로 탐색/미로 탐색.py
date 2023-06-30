from collections import deque
import sys

def Maze_Explore():
    result = []
    dq = deque([[0, 0, 1]])
    check[0][0] = False

    while dq:
        n = dq.popleft()
        x = n[0]
        y = n[1]
        count = n[2]

        if x == M - 1 and y == N - 1:
            result.append(count)
            continue

        go_x = x + 1
        go_y = y

        if go_x != -1 and go_x != M and go_y != - 1 and go_y != N:
            if check[go_y][go_x]:
                check[go_y][go_x] = False
                dq.append([go_x, go_y, count + 1])

        go_x = x - 1
        go_y = y

        if go_x != -1 and go_x != M and go_y != - 1 and go_y != N:
            if check[go_y][go_x]:
                check[go_y][go_x] = False
                dq.append([go_x, go_y, count + 1])

        go_x = x
        go_y = y + 1

        if go_x != -1 and go_x != M and go_y != - 1 and go_y != N:
            if check[go_y][go_x]:
                check[go_y][go_x] = False
                dq.append([go_x, go_y, count + 1])

        go_x = x
        go_y = y - 1

        if go_x != -1 and go_x != M and go_y != - 1 and go_y != N:
            if check[go_y][go_x]:
                check[go_y][go_x] = False
                dq.append([go_x, go_y, count + 1])

    return print(min(result))

N, M = map(int, sys.stdin.readline().split())
maze = []
check = [[True for _ in range(M)] for _ in range(N)]

for i in range(N):
    maze.append(sys.stdin.readline())
    for j in range(M):
        if maze[i][j] == '0':
            check[i][j] = False
            
Maze_Explore()