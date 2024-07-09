N = int(input())
A = list(map(int, input().split()))

m = A[0] + A[1]

for i in range(N-1):
    high = N-1
    low = i + 1
    while high >= low:
        if N == 2:
            a = A[0] + A[1]
            break
        else:
            mid = (high + low) // 2
            a = A[i] + A[mid]
            if a == 0:
                m = a
                break
            else:
                if a < 0:
                    low = mid + 1
                elif a > 0:
                    high = mid - 1
                else:
                    a = 0
                    break
                if abs(a) < abs(m):
                    m = a

print(m)