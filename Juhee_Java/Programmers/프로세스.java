package Programmers;

import java.util.Collections;
import java.util.PriorityQueue;

class 프로세스 {
    public static int solution(int[] priorities, int location) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;

        for (int p : priorities) {
            priorityQueue.add(p);
        }

        while (!priorityQueue.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == priorityQueue.peek()) {
                    priorityQueue.poll();
                    answer += 1;
                    if (i == location) {
                        return answer;
                    }

                }
            }
        }

        return answer;
    }
}
