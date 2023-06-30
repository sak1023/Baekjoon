string = input().strip()
if(len(string) > 0):
    cnt = 1
    for i in string:
        if(i == ' '):
            cnt += 1
else:
    cnt = 0
print(cnt)