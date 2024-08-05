N = int(input())
charArr = input()

'''
alpa = ''
alli = []
start = 0
maxlen = 0
for idx, al in enumerate(charArr):
    if not(al in alpa):
        alli.append(idx)
    alpa += al
    if len(set(alpa)) > N:
        while(len(set(alpa)) > N):
            alpa = alpa[alli[0]:idx-1]
            alli.pop(0)
    maxlen = max(maxlen, len(alpa))
'''

start = 0
alpaDic = {}
alpa = []
maxlen = 0
for idx, al in enumerate(charArr):
    if al not in alpa:
        alpa.append(al)
        alpaDic[al] = 1
    else:
        alpaDic[al] += 1

    while(len(alpa) > N):
        alpaDic[charArr[start]] -= 1
        if alpaDic[charArr[start]] <= 0:
            alpa.remove(charArr[start])
        start += 1


    maxlen = max(maxlen, idx - start + 1)

print(maxlen)

