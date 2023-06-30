X = int(input())

cnt = 0
cnt_cnt = 0
num = 0
den = 0

while cnt_cnt < X:
    cnt += 1
    cnt_cnt += cnt

if cnt % 2 == 0:
    num = cnt - (cnt_cnt - X)
    den = 1 + (cnt_cnt - X)
else:
    num = 1 + (cnt_cnt - X)
    den = cnt - (cnt_cnt - X)
    
print(f'{num}/{den}')