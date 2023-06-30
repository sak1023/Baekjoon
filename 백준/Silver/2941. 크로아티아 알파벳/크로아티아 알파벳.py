String = input()
Croatia = 'c= c- dz= d- lj nj s= z='.split()
for i in Croatia:
    String = String.replace(i, 'a')
print(len(String))