def div(Num):
    for i in range((Num // 3) + 1):
        for j in range((Num // 3) + 1):
            if (i * 3) + (j * 5) == Num:
                return i + j
    return -1
        
print(div(int(input())))