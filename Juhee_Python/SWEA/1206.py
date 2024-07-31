# 앞 뒤로 2개씩 본 다음 가장 큰 값을 뺀 값 구하기

N = int(input())

answer = []
for i in range(N):
    a = list(map(int, input().split()))
    count = 0
    for j in range(2, len(a) -2):
        c = a[i-2:i] + a[i+1:i+3]

        if a[i] > max(c):
            count += a[i] - max(c)
    answer.append(count)

for i in range(len(answer)):
    print(f"{i+1}, {answer[i]}")