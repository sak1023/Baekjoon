N, M = map(int, input().split())
Board = []
Paint = 32

for i in range(N):
    Board.append(input())
        
for x1 in range(N - 7):
    for y1 in range(M - 7):
        Ex_B = 0
        Ex_W = 0
        for x2 in range(x1, x1 + 8):
            for y2 in range(y1, y1 + 8):
                if x2 % 2 == 0:
                    if y2 % 2 == 0:
                        if Board[x2][y2] != 'B':
                            Ex_B += 1
                        else:
                            Ex_W += 1
                    else:
                        if Board[x2][y2] == 'B':
                            Ex_B += 1
                        else:
                            Ex_W += 1
                else:
                    if y2 % 2 == 0:
                        if Board[x2][y2] == 'B':
                            Ex_B += 1
                        else:
                            Ex_W += 1
                    else:
                        if Board[x2][y2] != 'B':
                            Ex_B += 1
                        else:
                            Ex_W += 1
        if Ex_B < Ex_W and Ex_B < Paint:
            Paint = Ex_B
        elif Ex_W < Ex_B and Ex_W < Paint:
            Paint = Ex_W
            
print(Paint)