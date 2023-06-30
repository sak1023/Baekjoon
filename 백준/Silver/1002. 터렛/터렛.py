import sys
import math

T = int(sys.stdin.readline())

for i in range(T):
    x1, y1, r1, x2, y2, r2 = map(int, sys.stdin.readline().split())
    distance = float(math.sqrt((abs(x2 - x1) ** 2) + (abs(y2 - y1) ** 2)))

    if x2 - x1 != 0 or y2 - y1 != 0:
        if distance < r1 + r2:
            if distance > abs(r2 - r1):
                print(2)
            elif distance < abs(r2 - r1):
                print(0)
            else:
                print(1)
        elif distance > r1 + r2:
            print(0)
        else:
            print(1)
    elif r1 == r2:
        print(-1)
    else:
        print(0)