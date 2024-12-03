A = list(input().rstrip())
s = set()

for i in range(len(A)):
    for j in range(i+1, len(A)+1):
        a = ''.join(A[i:j])
        s.add(a)
print(len(s))