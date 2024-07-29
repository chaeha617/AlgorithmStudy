N = int(input()) # 시험장 수
a = list(map(int, input().split()))

b, c = map(int, input().split()) # 총감독 가능, 부감동 가능
count = len(a)


for i in range(N):
    a[i] -= b
    if a[i] < 0:
        continue
    else:
        if a[i] % c == 0:
            count += (a[i]//c)
        else:
            count += (a[i]//c+1)

print(count)



