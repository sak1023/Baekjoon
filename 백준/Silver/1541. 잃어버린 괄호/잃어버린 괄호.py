import sys

array = sys.stdin.readline().split("-")

result = 0

for i in array[0].split("+"):
    result += int(i)
    
for i in array[1:]:
    for j in i.split("+"):
        result -= int(j)
            
print(result)