from collections import deque
import sys


def Cut_Paper(x, y, l):
    white = 0
    blue = 0

    for i in range(y, y + l):
        for j in range(x, x + l):
            if paper[i][j] == 0:
                white += 1
            else:
                blue += 1

    if white == 0:
        return "0 1"
    elif blue == 0:
        return "1 0"
    else:
        ans1, ans2 = 0, 0
        tmp1, tmp2 = map(int, Cut_Paper(x, y, l // 2).split())
        ans1 += tmp1
        ans2 += tmp2
        tmp1, tmp2 = map(int, Cut_Paper(x + l // 2, y, l // 2).split())
        ans1 += tmp1
        ans2 += tmp2
        tmp1, tmp2 = map(int, Cut_Paper(x, y + l // 2, l // 2).split())
        ans1 += tmp1
        ans2 += tmp2
        tmp1, tmp2 = map(int, Cut_Paper(x + l // 2, y + l // 2, l // 2).split())
        ans1 += tmp1
        ans2 += tmp2
        return str(ans1) + " " + str(ans2)

N = int(sys.stdin.readline())

paper = [[] for _ in range(N)]

for i in range(N):
    s = list(map(int, sys.stdin.readline().split()))

    for j in s:
        paper[i].append(j)

for i in Cut_Paper(0, 0, N).split():
    print(i)