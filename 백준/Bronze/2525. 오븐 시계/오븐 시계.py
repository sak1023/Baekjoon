H, M = map(int, input().split())

Timer = int(input())

M += Timer

if M > 59:
    H += M // 60
    
    if H > 23:
        H -= H // 24 * 24
        
    M -= M // 60 * 60
    
    
print(H, M)