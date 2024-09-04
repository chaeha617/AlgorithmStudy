from itertools import product
def solution(word):
    answer = 0
    li = list(set(map(''.join, product(['A', 'E', 'I', 'O', 'U',''],repeat=5))))
    li.sort()
    return li.index(word)

print(solution("AAA"))