from itertools import combinations
def solution(nums):
    answer = 0

    for i in list(combinations(nums, 3)):
        s = sum(i)
        count = 0
        for j in range(1, s+1):
            if s % j == 0:
                count += 1
        if count == 2:
            answer += 1
    print(answer)

solution([1,2,3,4])
solution([1,2,7,6,4])