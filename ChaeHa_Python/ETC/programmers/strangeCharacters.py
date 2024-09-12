def solution(s):
    answer = ''
    cnt = 0
    for ch in s:
        char = ch
        if cnt % 2 == 0:
            char = ch.upper()
        else:
            char = ch.lower()
        cnt += 1
        if ch == " ":
            cnt = 0
        answer += char
    return answer

print(solution("hello from the other side"))