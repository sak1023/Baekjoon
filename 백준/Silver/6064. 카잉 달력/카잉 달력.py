import sys

T = int(sys.stdin.readline())

for _ in range(T):
    M, N, x, y = map(int, sys.stdin.readline().split())
    count = 0
    check = False
    
    if M > N:
        while True:
            if (M * count + x) % N == y % N:
                print(M * count + x)
                break
            
            count += 1
            
            if M * count + x > M * N:
                check = True
                break
    elif M < N: 
        while True:
            if (N * count + y) % M == x % M:
                print(N * count + y)
                break
            
            count += 1
            
            if N * count + y > M * N:
                check = True
                break
    else:
        if M >= x and x == y:
            print(x)
        else:
            check = True
    if check:
        print(-1)