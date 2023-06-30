import sys

def Get_House_Number(x, y):
    count = 0

    if check[y][x]:
        check[y][x] = False
        count += 1

        if x != N - 1:
            count += Get_House_Number(x + 1, y)
        if x != 0:
            count += Get_House_Number(x - 1, y)
        if y != N - 1:
            count += Get_House_Number(x, y + 1)
        if y != 0:
            count += Get_House_Number(x, y - 1)

    return count

N = int(sys.stdin.readline())

check = [[] for _ in range(N)]
result = []

for i in range(N):
    s = sys.stdin.readline().strip()

    for j in s:
        if j == '0':
            check[i].append(False)
        else:
            check[i].append(True)

for i in range(N):
    for j in range(N):
        if check[i][j]:
            n = Get_House_Number(j, i)
            if n != 0:
                result.append(n)

result.sort()

print(len(result))

for i in result:
    print(i)
