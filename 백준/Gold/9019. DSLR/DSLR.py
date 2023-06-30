from collections import deque
import sys

T = int(sys.stdin.readline())

for _ in range(T):
    A, B = map(int, sys.stdin.readline().split())
    visited = [True] * 10000
    dq = deque([["", A]])

    while True:
        node = dq.popleft()
        word = node[0]
        now = node[1]

        if now * 2 % 10000 == B:
            print(word + "D")
            break
        elif visited[now * 2 % 10000]:
            dq.append([word + "D", now * 2 % 10000])
            visited[now * 2 % 10000] = False

        if (now - 1) % 10000 == B:
            print(word + "S")
            break
        elif visited[(now - 1) % 10000]:
            dq.append([word + "S", (now - 1) % 10000])
            visited[(now - 1) % 10000] = False

        tmpnow = "0" * (4 - len(str(now))) + str(now)
        tmpL = int(tmpnow[1:] + tmpnow[0])
        tmpR = int(tmpnow[3] + tmpnow[:3])

        if tmpL == B:
            print(word + "L")
            break
        elif visited[tmpL]:
            dq.append([word + "L", tmpL])
            visited[tmpL] = False
            
        if tmpR == B:
            print(word + "R")
            break
        elif visited[tmpR]:
            dq.append([word + "R", tmpR])
            visited[tmpR] = False