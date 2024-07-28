from collections import deque
def solution(tickets):
    answer = ["ICN"]
    tripdic = {}
    tickets.sort()
    for starttrip, endtrip in tickets:
        if starttrip not in tripdic.keys():
            tripdic[starttrip] = [endtrip]
        else:
            tripdic[starttrip].append(endtrip)

    queue = deque(["ICN"])
    while queue:
        start = queue.popleft()
        for next_node in tripdic[start]:
            if next_node not in answer:
                answer.add(next_node)
                queue.append(next_node)


    return answer

print(solution([["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]]))
print(solution([["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]]))