import sys

arr = []

for i in range(5):
    arr.append(int(sys.stdin.readline()))

print(sum(arr) // 5, sorted(arr)[2])