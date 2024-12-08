import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }

        int answer = 0;
        int num = pq.peek();
        while (num < K) {
            int num1 = pq.poll();
            int num2 = pq.poll();
            int temp = num1 + (num2 * 2);
            pq.add(temp);

            num = pq.peek();
            answer++;

            if(pq.size() == 1 && num < K) return -1;
        }
        return answer;
    }
}