import sys # 계속 시간초과 나길래 넣어봤는데 드디어 이 친구를 왜 쓰는지 알았다...
input = sys.stdin.readline
S, E, Q = input().split()

S = int(S[:2]) * 60 + int(S[3:])
E = int(E[:2]) * 60 + int(E[3:])
Q = int(Q[:2]) * 60 + int(Q[3:])

att = set()
count = 0

while True:
    try:
        time, name = input().split()
        time = int(time[:2]) * 60 + int(time[3:])
        if time <= S:
            att.add(name)
        elif name in att and E <= time <= Q:
            att.remove(name)
            count += 1
    except:
        break

print(count)
