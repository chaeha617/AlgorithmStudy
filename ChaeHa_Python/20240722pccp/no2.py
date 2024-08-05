import itertools
def solution(ability):
    answer = 0
    li = [x for x in range(len(ability[0]))]
    li = itertools.permutations(li,len(li))
    for i in li:
        tot = 0
        ab = ability.copy()
        for j in i:
            ab.sort(key=lambda x: x[j])
            tot += ab.pop()[j]
        if tot > answer:
            answer = tot
    return answer

print(solution([[20, 30], [30, 20], [20, 30]]))