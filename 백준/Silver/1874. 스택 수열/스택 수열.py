import sys

n = int(sys.stdin.readline())
cnt = 0
str = ""
arr = [None for _ in range(n)]

for _ in range(n):
    num = int(sys.stdin.readline())

    while cnt < num:
        str += "+\n"
        cnt += 1

    str += "-\n"

    arr[num - 1] = 0

    if num < cnt and arr[num] == None:
        print("NO")
        sys.exit(0)


print(str.strip())