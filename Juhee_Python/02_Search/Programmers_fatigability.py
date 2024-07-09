#피로도
from itertools import permutations
def solution(k, dungeons):
    answer = []
    for i in permutations(dungeons, len(dungeons)):
        count = 0
        c = k
        cnt = 0
        for a, b in i:
            if c >= a:
                c -= b
                cnt += 1
        answer.append(cnt)
    return max(answer)


#모든 경우 구하기 -> 순열

print(solution(80, [[80,20],[50,40],[30,10]]))