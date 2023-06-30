import sys

nums = [9, 7, 8, 0, 9, 2, 1, 4, 1, 8]
s = 0

for _ in range(3):
    nums.append(int(sys.stdin.readline()))

for i in range(13):
    s += (lambda x, y : y if x % 2 == 0 else y * 3)(i, nums[i])

print("The 1-3-sum is " + str(s))