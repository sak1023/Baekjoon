N = int(input())
MTP = 6
Count = 1
Result = 1

while True:
    if Result < N:
        Result += MTP * Count
        Count += 1
    else:
        print(Count)
        break