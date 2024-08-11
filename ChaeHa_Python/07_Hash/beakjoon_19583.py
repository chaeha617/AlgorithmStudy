import sys
input = sys.stdin.readline
def timeTrans(ti):
    ti = ti.replace(":", "")
    return int(ti)

answer = 0
timeDic = {}
endlist = set()
S, E, Q = map(timeTrans ,input().split(" "))


while True:
    try:
        a, b = input().split(" ")
        if b in endlist:
            continue
        else:
            a = timeTrans(a)
            if a <= S:
                if not b in timeDic:
                    timeDic[b] = 1
            elif a >= E and a <= Q:
                if b in timeDic:
                    endlist.add(b)
    except:
        print(len(endlist))
        break
