from itertools import combinations
def solution(number):
    count = 0
    for comb in list(combinations(number, 3)):
        if sum(comb) == 0:
            count += 1
    return count

print(solution([-2, 3, 0, 2, -5]))
print(solution([-3, -2, -1, 0, 1, 2, 3]))
print(solution([-1, 1, -1, 1]))