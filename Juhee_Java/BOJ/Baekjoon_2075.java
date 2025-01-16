package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon_2075 {
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                priorityQueue.add(-temp);
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer = priorityQueue.poll();
        }
        if (answer > 0) {
            System.out.println(-answer);
        } else {
            System.out.println(Math.abs(answer));
        }

    }
}
