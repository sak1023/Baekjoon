num=int(input())
score=input().split()
max=int(0)
sum=int(0)
for i in range(num):
  if(max < int(score[i])):
    max=int(score[i])
for i in range(num):
  sum += int(score[i])/max*100
print(sum/num)