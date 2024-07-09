#차집합

a, b = map(int, input().split())
A = set(map(int, input().split()))
B = set(map(int, input().split()))

answer = A - B

answer = list(answer)
answer.sort()

print(len(answer))
print(' '.join(map(str, answer)))


'''
시간 초과 풀이
a, b = map(int, input().split())
A = list(map(int, input().split()))
B = list(map(int, input().split()))

answer = []
for i in A:
    if i in B:
        pass
    else:
        answer.append(i)

print(len(answer))
print(' '.join(map(str, answer)))
'''