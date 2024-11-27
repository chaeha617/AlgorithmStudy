N = int(input())

SK = True
while N > 1:
    if N > 4:
        if N % 2 == 1:
            N -= 4
        else:
            N -= 3
    else:
        if N % 2 == 1:
            SK = not SK
        break
    SK = not SK


if SK:
    print("SK")
else:
    print("CY")

'''
    
1 -> 짐
3 -> 짐
4 - > 이김 1 + 3 1 1 1 1
6 - > 4 1 1 = 변경됨 3 3 변경됨
7 - > 4 3 / 1 3 3 
4의 변수 -> 승리자를 변경시킴
'''