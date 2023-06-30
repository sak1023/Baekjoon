import sys

STR_A = sys.stdin.readline().strip()
STR_B = sys.stdin.readline().strip()
LEN_A = len(STR_A)
LEN_B = len(STR_B)
dp = [[0 for _ in range(LEN_B + 1)] for _ in range(LEN_A + 1)]

for i in range(LEN_A):
    for j in range(LEN_B):
        if STR_A[i] == STR_B[j]:
            dp[i + 1][j + 1] = dp[i][j] + 1
        else:
            dp[i + 1][j + 1] = max(dp[i + 1][j], dp[i][j + 1])

print(dp[LEN_A][LEN_B])