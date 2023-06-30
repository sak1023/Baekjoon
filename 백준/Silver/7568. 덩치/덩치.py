N = int(input())

Matrix = []
Ranking = [1] * N

for i in range(N):
    Matrix.append(list(map(int, input().split())))
    
for i in range(N):
    for j in range(N):
        if Matrix[i][0] < Matrix[j][0]\
        and Matrix[i][1] < Matrix[j][1]:
            Ranking[i] += 1

for i in Ranking:
    print(i)