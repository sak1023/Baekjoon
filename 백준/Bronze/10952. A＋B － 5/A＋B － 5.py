a=0
b=0
while(1):
  a, b = map(int, input().split())
  if(a==0 and b==0):
    break;
  else:
    print(a+b)