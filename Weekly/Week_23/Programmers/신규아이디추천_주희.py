def solution(new_id):
    answer = new_id.lower()
    result = []

    for i in range(len(answer)):
        if answer[i].isalpha() or answer[i] == '-' or answer[i] == '_' or answer[i] == "." or answer[i].isdigit():
            if (answer[i] == "." and not result) or (answer[i] == "." and result[-1] == "."):
                continue
            else:
                result.append(answer[i])

    if not result:
        result.append("a")

    if len(result) >= 16:
        result = result[:15]
        found = False
        while found == False:
            if result[-1] == ".":
                result.pop()
            else:
                found = True

    found = False
    while found == False:
        if result[-1] == ".":
            result.pop()
        else:
            found = True

    if len(result) <= 2:
        a = result[-1]
        while len(result) < 3:
            result.append(a)

    print(''.join(result))

    return ''.join(result)

#solution("...!@BaT#*..y.abcdefghijklm") # "bat.y.abcdefghi"
#solution("z-+.^.")
#solution("=.=")
solution("123_.def")
solution("abcdefghijklmn.p")