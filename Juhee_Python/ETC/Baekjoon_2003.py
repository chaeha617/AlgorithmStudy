N, M = map(int, input().split())

L = list(map(int, input().split()))
L.sort()

left = 0
right = len(L)-1
count = 0
answer = 0

while left < right:
    a = L[left] + L[right]
    if a == M:
        answer += 1
        left += 1
    if a > M:
        right -= 1
    if a < M:
        left += 1
print(answer)

