'''
초기값 : dp(1,2) = 1
점화식 :

'''

N = int(input())
field = []
for _ in range(N):
    field.append(list(map(int,input().split(" "))))

dp = []

