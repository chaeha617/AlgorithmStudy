import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> priorityQueueLowest = new PriorityQueue<>();
        for(int i=0; i<scoville.length; i++) {
            priorityQueueLowest.add(scoville[i]);
        }

        int a = 0;
        int b = 0;

        while (priorityQueueLowest.peek() < K && priorityQueueLowest.size()>1) {
            a = priorityQueueLowest.poll();
            b = priorityQueueLowest.poll();
            priorityQueueLowest.add(a + (b*2));
            answer++;
        }
        if(priorityQueueLowest.peek() < K) answer=-1;
        return answer;
    }
}