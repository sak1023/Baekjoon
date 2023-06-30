import sys

T = int(sys.stdin.readline())

result = ""

for _ in range(T):
    N, M = map(int, sys.stdin.readline().split())
    q = list(map(int, sys.stdin.readline().split()))
    cnt = 1
    while True:
        if q[0] == max(q):
            if M == 0:
                result += str(cnt) + "\n"
                break
            else:
                del q[0]
                cnt += 1
                M -= 1
        else:
            q.insert(len(q), q.pop(0))
            if M == 0:
                M = len(q) - 1
            else:
                M -= 1

print(result.strip())