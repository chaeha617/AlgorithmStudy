def solution(original, actions):
    for action in actions:
        parts = action.strip().split()
        index = int(parts[0])
        count = int(parts[1])
        numbers_to_insert = parts[2:2 + count]
        original[index:index] = numbers_to_insert

    return original


T = 10  # 테스트 케이스 수
for test_case in range(1, T + 1):
    N = int(input())
    original = input().split()
    num_actions = int(input())
    actions = input().split("I")
    actions = [a.strip() for a in actions if a]

    result = solution(original, actions)
    result = ' '.join(result[:10])
    print(f"#{test_case} {result}")
