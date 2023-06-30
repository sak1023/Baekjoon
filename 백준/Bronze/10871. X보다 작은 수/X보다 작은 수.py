import sys
A=[]
N, X = map(int, input().split())
B = list(input().split())
for i in range(N):
  if(int(B[i])<X):
    A.append(B[i])  
for i in range(len(A)):
  print(A[i], end=' ')