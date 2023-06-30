import sys

N = int(sys.stdin.readline())
pole = [0 for _ in range(500)]
dp = [N - 1] * 500

for i in range(N):
    A, B = map(int, sys.stdin.readline().split())
    pole[A - 1] = B

for i in range(500):
    if pole[i]:
        for j in range(i):
            if pole[j]:
                if pole[i] > pole[j]:
                    dp[i] = min(dp[i], dp[j] - 1)

print(min(dp))