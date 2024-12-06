import re

def solution(new_id):
    answer = ""
    new_id = new_id.lower()
    for ch in new_id:
        if re.fullmatch('[a-z0-9\-_.]', ch):
            if ch == "." and (answer == "" or answer[-1] == "."):
                continue
            answer += ch

    if not answer:
        answer = "a"

    if len(answer) > 15:
        answer = answer[:15]

    if answer[-1] == ".":
        answer = answer[:-1]

    while len(answer) < 3:
        answer += answer[-1]

    return answer