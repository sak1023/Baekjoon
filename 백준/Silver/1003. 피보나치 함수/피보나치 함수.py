import sys

T = int(sys.stdin.readline())

for _ in range(T):
    N = int(sys.stdin.readline())
    
    dp = [0, 1]
    
    for i in range(2, N + 1):
        dp.append(dp[i - 1] + dp[i - 2])
        
    print(dp[N - 1], dp[N])