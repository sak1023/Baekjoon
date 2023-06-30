import sys

ax, ay, az = map(int, sys.stdin.readline().split())
cx, cy, cz = map(int, sys.stdin.readline().split())

print(str(cx - az) + " " +str(cy // ay) + " " +str(cz - ax))