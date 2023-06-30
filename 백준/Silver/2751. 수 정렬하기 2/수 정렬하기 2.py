N = int(input())
List = []

for _ in range(N):
    List.append(int(input()))

def Merge_Sort(List_BS):
    if len(List_BS) == 1:
        return List_BS
    
    List1 = Merge_Sort(List_BS[0: len(List_BS) // 2])
    List2 = Merge_Sort(List_BS[len(List_BS) // 2: len(List_BS)])
        
    L1 = 0
    L2 = 0
    Merged_List = []
    
    while L1 < len(List1) and L2 < len(List2):
        if List1[L1] > List2[L2]:
            Merged_List.append(List2[L2])
            L2 += 1
        else:
            Merged_List.append(List1[L1])
            L1 += 1
            
    if L1 == len(List1):
        Merged_List += List2[L2:]
    else:
        Merged_List += List1[L1:]
        
    return Merged_List

for i in Merge_Sort(List):
    print(i)