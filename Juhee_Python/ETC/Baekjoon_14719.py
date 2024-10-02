H, W = map(int, input().split())
# 바닥은 항상 막혀있음

A = list(map(int, input().split()))

m = A[0]
m2 = A[1]
count = 0
for j in range(1, W-1):
    print(count)
    if A[j] >= m:
        if j+1 <= W:
            m2 = A[j+1]
        m = A[j]
    if A[j] > m2:
        count += m - m2
        m2 = A[j]
    else:
        count += m - A[j]

# 맨 앞을 기준 잡고 그 다음을 또 잡아
# 그 다음보다 큰 게 나오면 거기까기 더하고 기준 새로 잡기?
