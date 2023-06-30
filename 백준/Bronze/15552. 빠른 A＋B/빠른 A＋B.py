import sys

R = int(input())

for i in range(R):
    A, B = map(int, sys.stdin.readline().split())
    print("{}".format(A+B))