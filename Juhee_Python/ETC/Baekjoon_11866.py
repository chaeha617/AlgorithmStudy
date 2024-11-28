from collections import deque
N, K = map(int, input().split())

q = deque(i for i in range(1, N+1))
answer = []

while q:
    q.rotate(-(K-1))
    a = q.popleft()
    answer.append(a)

print("<", end="")
for i in answer:
    if i != answer[-1]:
        print(i, end=", ")
    else:
        print(i, end=">")
