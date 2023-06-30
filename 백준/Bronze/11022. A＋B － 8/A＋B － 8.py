import sys

R = int(input())

for i in range(R):
    A, B = map(int, sys.stdin.readline().split())
    print("Case #{}: {} + {} = {}".format(i+1, A, B, A+B))
    