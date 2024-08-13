import sys

input = sys.stdin.readline
N = int(input())

d = {}
total_sum = 0
numbers = []

# 입력 처리
for _ in range(N):
    a = int(input())
    total_sum += a  # 합 계산
    numbers.append(a)

    if a in d:
        d[a] += 1
    else:
        d[a] = 1

# 평균 계산 (소수 첫째 자리에서 반올림)
mean = round(total_sum / N)
print(mean)

# 중앙값 계산
numbers.sort()
median = numbers[N // 2]
print(median)

# 최빈값 계산
# 빈도수를 기준으로 정렬
sorted_by_freq = sorted(d.items(), key=lambda x: (-x[1], x[0]))
modes = [k for k, v in sorted_by_freq if v == sorted_by_freq[0][1]]

# 최빈값이 여러 개일 경우 두 번째로 작은 값 출력
if len(modes) > 1:
    print(modes[1])
else:
    print(modes[0])

# 범위 계산 (최댓값 - 최솟값)
range_value = max(numbers) - min(numbers)
print(range_value)
