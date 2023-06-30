import sys

T = int(sys.stdin.readline())

for _ in range(T):
    a, b = map(int, sys.stdin.readline().split())
    nums = [a % 10]
    check = nums[0] * a % 10
    
    while not check in nums:
        nums.append(check)
        check = check * a % 10
    
    ans = nums[b % len(nums) - 1]
    
    if ans == 0:
        print(10)
    else:
        print(ans)