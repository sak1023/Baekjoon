def S(K, N):
    Sum = []
    for i in range(N):
        Sum.append(i + 1)
        
    Sum.append(0)
    
    for i in range(K - 1):    
        for j in range(N):
            Sum[j] += Sum[j - 1]
            
    return sum(Sum)

def answer(T):
    for i in range(T):
        k = int(input())
        n = int(input())
        
        Sum = 0
        Sum = S(k, n)
        
        print(Sum)
    
answer(int(input()))