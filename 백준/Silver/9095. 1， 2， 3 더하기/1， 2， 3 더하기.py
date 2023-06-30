import sys
T = int(sys.stdin.readline())
dp = [1, 2, 4, 7, 13, 24, 44, 81, 149, 274]
for _ in range(T):
    n = int(sys.stdin.readline())
    print(dp[n - 1])