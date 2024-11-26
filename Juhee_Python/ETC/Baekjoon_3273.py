N = int(input())
L = list(map(int, input().split()))
X = int(input())


L.sort()
left, right = 0, N-1
count = 0

while left < right:
    s = L[left] + L[right]
    if s == X:
        left += 1
        right -= 1
        count += 1
    else:
        if s < X:
            left += 1
        else:
            right -= 1

print(count)