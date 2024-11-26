N = int(input())

a =[[0] * 10 for _ in range(N)]

a[0] = [0,1,1,1,1,1,1,1,1,1]

for i in range(1, N):
    a[i][0] = a[i-1][1] # 끝자리가 0
    a[i][9] = a[i-1][8] # 끝자리가 9

    for k in range(1, 9): # 끝자리가 1~8
        a[i][k] = a[i-1][k-1] + a[i-1][k+1]
print(sum(a[N - 1]) % 1000000000)