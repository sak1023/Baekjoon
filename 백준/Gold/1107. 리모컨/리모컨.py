import sys

N = int(sys.stdin.readline())
M = int(sys.stdin.readline())
button = list(map(int, sys.stdin.readline().split()))
ans = abs(100 - N)

for i in range(1000001):
    nums = str(i)
    count = 0
    
    for j in nums:
        count += 1
        if int(j) in button:
            break
        elif count == len(nums):
            ans = min(ans, abs(i - N) + len(nums))

print(ans)