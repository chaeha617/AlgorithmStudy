import sys
input = sys.stdin.read

data = input().split()
T = int(data[0])
index = 1

for t in range(T):
    N = int(data[index])
    index += 1
    count = 0
    for i in range(N):
        k = int(data[index + i])
        if k % 2 != 0:
            count += k
    index += N
    print(f"#{t+1} {count}")
