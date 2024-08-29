# 추억 점수 -> 그리움 점수 합

def solution(name, yearning, photo):
    d = dict()
    for i in range(len(name)):
        d[name[i]] = yearning[i]
    result = []
    for j in photo:
        answer = 0
        for k in j:
            if k in d:
                answer += d[k]
        result.append(answer)

    return result

print(solution(["may", "kein", "kain", "radi"], [5, 10, 1, 3], [["may", "kein", "kain", "radi"],["may", "kein", "brin", "deny"], ["kon", "kain", "may", "coni"]]))