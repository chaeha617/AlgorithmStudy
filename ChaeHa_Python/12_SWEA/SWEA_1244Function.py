T = int(input())
for test_case in range(1, T + 1):
    text, cnt = input().split()
    cnt = int(cnt)
    text = list(text)
    sortText = sorted(text, reverse=True)
    for idxCnt in range(cnt):
        if text == sortText:
            if len(text) != len(set(text)):
                break
            text[-1] = sortText[-2]
            text[-2] = sortText[-1]
        else:
            for idx in range(idxCnt, len(text)):
                if sortText[idx] != text[idx]:
                    textidx = text.index(sortText[idx])
                    text[textidx] = text[idx]
                    text[idx] = sortText[idx]
                    break
    print("#"+str(test_case),''.join(text))