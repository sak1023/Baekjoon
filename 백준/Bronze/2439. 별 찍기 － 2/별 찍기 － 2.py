N = int(input())
M = 0

for i in range(N):
  if(M>0):
    print("")
  M += 1
  for k in range(N-M):
    print(" ", end='')
  for j in range(M):
    print("*", end='')