import sys

vowel = ['a', 'i', 'u', 'e', 'o']

N = int(sys.stdin.readline())
S = sys.stdin.readline()
s = 0

for check in S:
    if check in vowel:
        s += 1

print(s)