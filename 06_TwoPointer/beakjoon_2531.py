N, d, k, c = map(int,input().split(" "))
sushi = []
for i in range(N):
    sushi.append(int(input()))

maxSushi = 0
for low in range(N):
    if low + k > len(sushi)-1:
        numnum = set(sushi[low:] + sushi[:low+k - N] +[c])
    else:
        numnum = set(sushi[low:low+k]+[c])
    if len(numnum) > maxSushi:
        maxSushi = len(numnum)

print(maxSushi)