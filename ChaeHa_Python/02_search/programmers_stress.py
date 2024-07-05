import itertools

def solution(k, dungeons):
    arr = list(itertools.permutations(dungeons, len(dungeons)))
    answer = 0
    for dunlist in arr:
        stress = k
        dun_count = 0
        for must_stress, use_stress in dunlist:
            if must_stress <= stress:
                stress -= use_stress
                dun_count += 1
            else:
                break
        if answer < dun_count:
            answer = dun_count

    return answer

print(solution(80, [[80,20],[50,40],[30,10]]	))