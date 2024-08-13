import sys
input = sys.stdin.readline
N = int(input())

A = []
for i in range(N):
    a,b = input().split()
    A.append([int(a), int(b)])

A.sort(key=lambda x:(x[1], x[0]))


count = 0
time = 0

for i, j in A:
    if i >= time:
        count += 1
        time = j
print(count)

# 시간 초과
# count = 0
#
# answer = []
#
# t = [[] for _ in range(N)]
# for k in range(len(A)):
#     B = A[k:]
#     for i, j in B:
#         if t[k] == []:
#             t[k].append(j)
#         else:
#             if i >= t[k][-1]:
#                 t[k].append(j)
#     answer.append(len(t[k]))
#
# print(max(answer))