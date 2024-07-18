A = []
for i in range(5):
    a = int(input())
    A.append(a)

answer1 = sum(A)//5

A.sort()
answer2 = A[2]

print(answer1)
print(answer2)