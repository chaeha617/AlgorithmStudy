import sys
import math
input = sys.stdin.readline

A, B = map(int, input().split())
print(math.gcd(A, B))
print(math.lcm(A, B))