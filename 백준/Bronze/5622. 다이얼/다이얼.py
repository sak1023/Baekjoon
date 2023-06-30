String = input()
Time = 0
Dial = ['ABC', 'DEF', 'GHI', 'JKL', 'MNO', 'PQRS', 'TUV', 'WXYZ']
for Alphabet in String:
    for Betabet in Dial:
        if Alphabet in Betabet:
            Time += Dial.index(Betabet) + 3
print(Time)