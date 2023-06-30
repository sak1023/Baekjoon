n = int(input())
s = 0
for i in range(n):
    if(n>0):
        s += n
        n -= 1
print("{}".format(s))