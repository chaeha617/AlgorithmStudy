A = int(input())
B = list(map(int, input().rstrip()))
B.reverse()

answer = 0

for i in range(len(B)):
    a = A * B[i]
    if i != 0:
        b = a * (10 ** i)
        answer += a * (10 ** i)
    else:
        answer += a
    print(a)

print(answer)