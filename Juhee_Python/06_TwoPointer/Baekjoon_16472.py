import sys
from collections import defaultdict

# 알파벳의 종류 최대 개수
N = int(input().strip())

# 문자열
S = list(sys.stdin.readline().rstrip())

max_length = 0
char_count = defaultdict(int)
left = 0

for right in range(len(S)):
    char_count[S[right]] += 1
    print(char_count)

    while len(char_count) > N:
        char_count[S[left]] -= 1
        if char_count[S[left]] == 0:
            del char_count[S[left]]
        left += 1

    max_length = max(max_length, right - left + 1)

print(max_length)
