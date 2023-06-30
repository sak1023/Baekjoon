def d(n):
    for i in list(str(n)):
        n += int(i)
    return n
def Self_Number():
    not_self_number = set()
    for i in range(10000):
        not_self_number.add(d(i+1))
    self_number = set(i+1 for i in range(10000)) - not_self_number
    self_number_list = list(self_number)
    self_number_list.sort()
    for i in self_number_list:
        print(i)

Self_Number()