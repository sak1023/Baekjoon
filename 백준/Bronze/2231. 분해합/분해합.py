N = int(input())

if N // 2 > N - len(str(N)) * 9:
    Factor = N // 2
else:
    Factor = N - len(str(N)) * 9

while True:
    if Factor >= N:
        print(0)
        break

    Sum = 0
    
    for i in range(len(str(Factor))):
        Sum += int(str(Factor)[i])
    if Factor + Sum == N:
        print(Factor)
        break
    
    Factor += 1