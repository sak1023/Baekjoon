N = int(input())
Num = 99
if(N >= 100):
    
    for i in range(100, N+1):
        n = list(map(int, str(i)))
        if((n[0] - n[1]) == (n[1] - n[2])):
            Num += 1
    print(Num)
else:
    print(N)