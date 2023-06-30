from collections import deque
import sys

def Balance(T):
    Str = ""
    
    for _ in range(T):
        S = sys.stdin.readline()
        
        parentheses = deque([])
        check = True
        
        for i in S:
            if i == "(":
                parentheses.append(0)
            elif i == ")":
                if len(parentheses) == 0:
                    Str += "NO\n"
                    check = False
                    break
                else:
                    parentheses.pop()
                    
        if check == True:
            if len(parentheses) == 0:
                Str += "YES\n"
            else:
                Str += "NO\n"
    
    print(Str.strip())

Balance(int(sys.stdin.readline()))