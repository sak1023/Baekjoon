import sys

while True:
    n1, n2 = map(int, sys.stdin.readline().split())
    
    if n1 == 0 and n2 == 0:
        sys.exit(0)
    
    print((lambda x, y: "Yes" if n1 > n2 else "No")(n1, n2))