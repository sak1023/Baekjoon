from collections import deque
import sys

def Stack(T):
    Str = ""
    nums = deque([])
    
    for _ in range(T):
        cmd = sys.stdin.readline()
        chk = cmd[0]
        Len = len(nums)
        
        if chk == "p":
            if len(cmd) > 4:
                nums.append(int(cmd[5:]))
            else:
                if Len != 0:
                    Str += str(nums.pop()) + "\n"
                else:
                    Str += "-1\n"
        elif chk == "s":
            Str += str(Len) + "\n"
        elif chk == "e":
            if Len == 0:
                Str += "1\n"
            else:
                Str += "0\n"
        elif chk == "t":
            if Len != 0:
                Str += str(nums[Len - 1]) + "\n"
            else:
                Str += "-1\n"
        
    print(Str.strip())

Stack(int(sys.stdin.readline()))