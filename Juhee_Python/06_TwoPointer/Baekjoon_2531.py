N, d, k, c = map(int, input().split())
A = []

for i in range(N):
    a = int(input())
    A.append(a)
count = []

A += A[:-1] # 원형으로 만들기
for i in range(N):
    a = [c]
    a += A[i:i+k]
    a = set(a)
    count.append(len(a))
    a =[c]


print(max(count))


