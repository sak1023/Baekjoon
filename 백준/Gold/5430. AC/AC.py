from collections import deque
import sys

T = int(sys.stdin.readline())
for _ in range(T):
    check = True
    R_check = False
    f = sys.stdin.readline().strip()
    f = f.replace("RR", "")
    arr_num = int(sys.stdin.readline())
    arr = deque(list(sys.stdin.readline()[1:-2].split(',')))
    
    if arr_num == 0:
        arr = []
    
    for execute in f:
        if execute == 'R':
            if R_check:
                R_check = False
            else:
                R_check = True
        elif execute == 'D':
            try:
                if R_check:
                    arr.pop()
                else:
                    arr.popleft()
            except:
                check = False
                print("error")
                break

    if check:
        if R_check:
            arr.reverse()

        print("[" + ','.join(arr).rstrip(',') + "]")