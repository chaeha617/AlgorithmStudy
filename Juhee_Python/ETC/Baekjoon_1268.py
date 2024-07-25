A = int(input())  # 학생 수

B = []

for i in range(A):
    a = list(map(int, input().split()))
    B.append(a)

answer = [0] * A

# 각 학생마다 다른 학생과 같은 반이었던 적이 있는지를 확인
for j in range(A):
    for k in range(A):
        if j != k:
            for year in range(5):
                if B[j][year] == B[k][year]:
                    answer[j] += 1
                    break

# 가장 많이 같은 반이었던 학생 찾기
max_value = max(answer)
for i in range(A):
    if answer[i] == max_value:
        print(i + 1)
        break
