from collections import deque
def solution(tickets):
    tripSet = set()
    for st, en in tickets:
        tripSet.add(st)
        tripSet.add(en)

    tripdic = {x : [] for x in tripSet}
    tickets.sort()
    for starttrip, endtrip in tickets:
        if starttrip not in tripdic.keys():
            tripdic[starttrip] = [endtrip]
        else:
            tripdic[starttrip].append(endtrip)



print(solution([["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]]))
print(solution([["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]]))
print(solution([["ICN", "D"], ["D", "ICN"], ["ICN", "B"]]))